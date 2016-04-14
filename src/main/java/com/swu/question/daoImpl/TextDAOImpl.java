package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.TextDAO;
import com.swu.question.entity.Text;
import com.swu.question.util.DivideHibernateUtil;

@Repository
public class TextDAOImpl implements TextDAO{
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	@SuppressWarnings("unchecked")
	public List<Text> listTextByCourseIdDividePage(String courseId,int pageNow,String findText) {
		// TODO Auto-generated method stub
		String hql = "from Text text where  text.course.courseId =? order by text.createTime DESC";
		if(findText!=null){
			findText= findText.trim();
			if(!findText.equals("")){
				hql = "from Text text where  text.course.courseId =? and  text.textTitle like ? order by text.createTime DESC";
			}
		}
		 Session session = sessionFactory.getCurrentSession();
		 DivideHibernateUtil dividePage = new DivideHibernateUtil();
		 List<Text> list = null;
		 if(findText!=null&&!findText.trim().equals("")){
			 String[] parameters=new String[2];
			 parameters[0] = courseId;
			 parameters[1]= "%"+findText+"%";
			 list = dividePage.executeQueryByPage(session, hql, parameters, pageNow);
		 }else{
			 String[] parameters=new String[1];
			 parameters[0] = courseId;
			 list = dividePage.executeQueryByPage(session, hql, parameters, pageNow);
		 }
		return list;
	}
	@Override
	public int countTextByCourseId(String courseId,String findText) {
		// TODO Auto-generated method stub
		String hql = "from Text text where text.course.courseId =:list ";
		if(findText!=null){
			findText= findText.trim();
			if(!findText.equals("")){
				 hql = "from Text text where  text.course.courseId =:list and  text.textTitle like :str";
			}
		}
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("list", courseId);
		if(findText!=null&&!findText.trim().equals("")){
			q.setString("str", "%"+findText+"%");
		}
		int sumCount = q.list().size();
		 DivideHibernateUtil dividePage = new DivideHibernateUtil();
		int sumPage = dividePage.getPageCount(sumCount);
		return sumPage;
	}
	
		@Override
		public  boolean addText(Text text) {
			// TODO Auto-generated method stub
			try{
			sessionFactory.getCurrentSession().save(text);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public  void deleteText(int textId) {
			// TODO Auto-generated method stub
			Text text = (Text) sessionFactory.getCurrentSession().load(
					Text.class, textId);
		        if (null != text) {
		            sessionFactory.getCurrentSession().delete(text);
		        }
		}
		
		
		@Override
		public Text queryText(int textId) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			Query q=sessionFactory.getCurrentSession().createQuery("from Text text where  text.textId=?");
			q.setParameter(0, textId);
			@SuppressWarnings("unchecked")
			List<Text>  texts = q.list();
			if(texts!=null&&texts.size()>0)
				return texts.get(0);
			else
				return null;
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<Text> queryTextByTeas(int teaId,int pageNow) {
			// TODO Auto-generated method stub
			String hql = "from Text text where  text.teacher.teaId =? order by text.createTime desc ";
			Session session = sessionFactory.getCurrentSession();
			DivideHibernateUtil dividePage = new DivideHibernateUtil();
			String[] parameters = new String[1];
			parameters[0] = teaId+"";
			List<Text> list = dividePage.executeQueryByPage(session, hql, parameters, pageNow);
				return list;
		}
		@Override
		public int countqueryTextByTeas(int teaId){
			String hql = "from Text text where  text.teacher.teaId =?";
			Query q=sessionFactory.getCurrentSession().createQuery(hql);
			q.setParameter(0, teaId);
			int sumCount = q.list().size();
			 DivideHibernateUtil dividePage = new DivideHibernateUtil();
			int sumPage = dividePage.getPageCount(sumCount);
			return sumPage;
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<Text> listText() {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().createQuery("from Text").list();
		}
		
		@Override
		public  List<Text> listTextByCourseId(int courseId){
			String hql = "from Text text where text.course.courseId =:list ";
			Query q=sessionFactory.getCurrentSession().createQuery(hql);
			q.setInteger("list", courseId);
			@SuppressWarnings("unchecked")
			List<Text> list=(List<Text>)q.list();
			return list;
		}
} 
