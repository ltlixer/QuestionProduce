package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.EvaluateDAO;
import com.swu.question.entity.Evaluate;
import com.swu.question.entity.Text;
@Repository
public class EvaluateDAOImpl  implements EvaluateDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addEvaluate(Evaluate evaluate) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(evaluate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Integer> queryEvaluateByStuId(int stuId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"select  e.text.textId from Evaluate e where  e.student.stuId =? group by e.text.textId");
		q.setParameter(0, stuId);
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) q.list();
		return list;
	}
	@Override
	public List<Integer> queryEvaluateByTextId(int textId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"select  e.text.textId from Evaluate e where  e.text.textId =? group by e.text.textId");
		q.setParameter(0, textId);
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) q.list();
		return list;
	}
	@Override
	public int countTextByCourseId(String courseId) {
		// TODO Auto-generated method stub
		String hql = "from Text text where text.course.courseId =:courseId";
		Query q=sessionFactory.getCurrentSession().createQuery(hql);
		q.setString("courseId", courseId);
		int sumCount = q.list().size();
		return sumCount;
	}
	@Override
	public List<Text> listEvaluated(int courseId){
	
		Query q = sessionFactory.getCurrentSession().createQuery(
				"select  e.text from Evaluate e where  e.text.course.courseId =? group by e.text.textId");
		q.setParameter(0, courseId);
		List<Text> list= q.list();
		return list;
	}
	@Override
	public List<Evaluate> listEvaluatedDownload(String courseId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Evaluate e where  e.text.course.courseId =? order by e.text.textId, e.sentenceId,e.question,e.student.stuId");
		q.setInteger(0, Integer.parseInt(courseId));
		@SuppressWarnings("unchecked")
		List<Evaluate> list= q.list();
		return list;
	}
	@Override
	public boolean deleteEvaluatebyStu(int textId, int stuId) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("delete from Evaluate e where e.text.textId=? and e.student.stuId =?");  
			//������������HQL���  
			   query.setInteger(0, textId);
			   query.setInteger(1, stuId);
			   query.executeUpdate();
			   return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
}
