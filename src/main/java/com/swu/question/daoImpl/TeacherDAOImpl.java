package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.TeacherDAO;
import com.swu.question.entity.Teacher;
import com.swu.question.util.DivideHibernateUtil;


/**
 * 实现Teacher实体类的数据库操作
 * @author 严浩
 *
 */ 
@Repository
public class TeacherDAOImpl implements TeacherDAO{
	 @Autowired
	   private SessionFactory sessionFactory;
	
	 @Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method 
		 sessionFactory.getCurrentSession().save(teacher);
		
	}
	@Override
	public List<Teacher> listTeacher() {
		// TODO Auto-generated method 
		@SuppressWarnings("unchecked")
		List<Teacher> list= sessionFactory.getCurrentSession().createQuery("From Teacher").list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> teacherLogin(String teaNum, String teaPass) {
		// TODO Auto-generated method 
		Query q= sessionFactory.getCurrentSession().createQuery("From Teacher s Where s.teaNum=? and s.teaPassword=?");
		q.setString(0, teaNum);
		q.setString(1, teaPass);
		List<Teacher> list = q.list();
		return list;
	}
	@Override
	public void deleteTeacher(Integer id) {
		// TODO Auto-generated method 
		Teacher teacher = (Teacher) sessionFactory.getCurrentSession().load(
				Teacher.class, id);
	        if (null != teacher) {
	            sessionFactory.getCurrentSession().delete(teacher);
	        }
	}
	@Override
	public void updatePassword(Integer id, String pswd) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) sessionFactory.getCurrentSession().load(
				Teacher.class, id);
	        if (null != teacher) {
	        	teacher.setTeaPassword(pswd);
	            sessionFactory.getCurrentSession().update(teacher);
	        }
	}
	@Override
	public void updateTeacherInfor(Teacher tea) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) sessionFactory.getCurrentSession().load(
				Teacher.class, tea.getTeaId());
	        if (null != teacher) {
	        	teacher.setTeaName(tea.getTeaName());
	        	teacher.setTeaMajor(tea.getTeaMajor());
	        	teacher.setTeaEmail(tea.getTeaEmail());
	            sessionFactory.getCurrentSession().update(teacher);
	        }
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> queryTeacher(int teaId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Teacher tea where tea.teaId=?");
		q.setInteger(0, teaId);
		List<Teacher> list = q.list();
		return list;
	}
	/*@Override
	@SuppressWarnings("unchecked")
	public List<Teacher> listTeacher(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Teacher";
		Session session = sessionFactory.getCurrentSession();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		List<Teacher> list = dividePage.executeQueryByPage(session, hql,null, pageNow);
		return list;
	}
	@Override
	public int listTeacher1() {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery("from Teacher");
		int sumCount = q.list().size();
		 DivideHibernateUtil dividePage = new DivideHibernateUtil();
		int sumPage = dividePage.getPageCount(sumCount);
		return sumPage;
	}*/



}
