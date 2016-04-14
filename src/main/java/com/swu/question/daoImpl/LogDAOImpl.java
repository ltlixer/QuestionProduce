package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.LogDAO;
import com.swu.question.entity.Log;

@Repository
public class LogDAOImpl implements LogDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Log> queryLogs() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Log> list = sessionFactory.getCurrentSession()
				.createQuery("From Log").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> queryLogsByAssId(int assId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Log log where log.assignment.assId=?");
		q.setParameter(0, assId);
		return q.list();
	}

	@Override
	public boolean deleteLogByAssId(int assId) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"delete from Log log where log.assignment.assId=?");
			// 跟据条件生成HQL语句
			query.setInteger(0, assId);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addLog(Log log) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(log);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> queryLogsByCourseIdStu(String courseId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Log log where log.stuId>0 and log.assignment.text.course.courseId=?");
		q.setString(0, courseId);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> queryLogsByCourseIdTea(String courseId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Log log where log.teaId>0 and log.assignment.text.course.courseId=?");
		q.setString(0, courseId);
		return q.list();
	}

}
