package com.swu.question.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.AssignmentDAO;
import com.swu.question.entity.Assignment;
import com.swu.question.entity.Course;
import com.swu.question.entity.Student;
import com.swu.question.util.DivideHibernateUtil;


@Repository
public class AssignmentDAOImpl implements AssignmentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Assignment> listAssignment() {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Assignment");
		@SuppressWarnings("unchecked")
		List<Assignment> list = q.list();
		return list;
	}

	@Override
	public boolean addAssignment(Assignment assignment) {

		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(assignment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public void deleteAssignment(int assId) {
		
		Assignment assignment = (Assignment) sessionFactory.getCurrentSession()
				.load(Assignment.class, assId);
		if (null != assignment) {
			sessionFactory.getCurrentSession().delete(assignment);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> selectAssignmentByCourseId(int courseId, String findAss) {
		// TODO Auto-generated method stub
		String hql = "from Assignment a where a.text.course.courseId=? order by a.createTime desc";
		if (findAss != null && !findAss.equals("")) {
			hql = "from Assignment a where a.text.course.courseId=? and a.text.textTitle like :str order by a.createTime desc";
		}
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter(0, courseId);
		if (findAss != null && !findAss.equals("")) {
			q.setString("str", "%" + findAss + "%");
		}
		return q.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Assignment> selectAssignmentByteaId(int teaId, int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from Assignment a where a.teacher.teaId = ? order by a.createTime ASC";
		String[] parameters = new String[1];
		parameters[0] = teaId + "";
		Session session = sessionFactory.getCurrentSession();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		List<Assignment> list = dividePage.executeQueryByPage(session, hql,
				parameters, pageNow);
		return list;
	}

	@Override
	public int countAssignmentByTeaId(Integer teaId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Assignment a where a.teacher.teaId = ?");
		q.setParameter(0, teaId);
		int sumCount = q.list().size();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		int sumPage = dividePage.getPageCount(sumCount);
		return sumPage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> listAllAssignment(Integer stuId) {
		// TODO Auto-generated method stub
		Query q1 = sessionFactory.getCurrentSession().createQuery(
				"from Student s where s.stuId = ?");
		q1.setParameter(0, stuId);
		Student student = (Student) q1.list().get(0);
		Set<Course> courses = student.getCourse();
		Query q = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Assignment a where a.text.course in (select s.course from Student s where s.stuId=?) and a.assId not in"
								+ "(select sa.saId from ScoreAssignment as sa where sa.student.stuId = ?) order by a.createTime asc");
		q.setParameter(0, stuId);
		q.setParameter(1, stuId);
		return q.list();
	}

	@Override
	public Assignment queryAssignment(Integer assId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Assignment a where a.assId=?");
		q.setParameter(0, assId);
		Assignment assignment = (Assignment) q.list().get(0);
		return assignment;
	}

	@Override
	public List<Assignment> queryAssignmentByTextId(Integer textId) {
		// TODO Auto-generated method stub
		
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Assignment a where a.text.textId=?");
		q.setParameter(0, textId);
		@SuppressWarnings("unchecked")
		List<Assignment> list = q.list();
		return list;
	}
}
