package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.CourseDAO;
import com.swu.question.entity.Course;
import com.swu.question.util.DivideHibernateUtil;


@Repository
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(course);
	}

	@Override
	public List<Course> listCourse() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Course> list = sessionFactory.getCurrentSession()
				.createQuery("From Course c where c.state>0").list();
		return list;
	}

	@Override
	public void deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		Course course = (Course) sessionFactory.getCurrentSession().load(
				Course.class, id);
		if (null != course) {
			sessionFactory.getCurrentSession().delete(course);
		}

	}
	@Override
	 public void stopCourse(Integer id){
		try {
			Course course = (Course) sessionFactory
					.getCurrentSession().load(Course.class, id);
			if (null != course) {
				course.setState(-1);
				sessionFactory.getCurrentSession().update(course);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public Course selectCourseById(int courseId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Course c where c.courseId=? and c.state>0");
		q.setParameter(0, courseId);
		Course course = (Course) q.list().get(0);
		return course;
	}

	@Override
	public List<Course> listCourse(int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Course c Where c.state>0";
		Session session = sessionFactory.getCurrentSession();
		 DivideHibernateUtil dividePage = new DivideHibernateUtil();
		List<Course> list = dividePage.executeQueryByPage(session, hql,null, pageNow);
		return list;
	}

}
