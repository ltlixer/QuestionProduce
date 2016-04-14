package com.swu.question.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.ScoreAssignmentDAO;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.util.DivideHibernateUtil;


@Repository
public class ScoreAssignmnetDAOImpl implements ScoreAssignmentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ScoreAssignment> listScoreAssignment() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createQuery("from ScoreAssignment").list();
	}

	@Override
	public void addScoreAssignment(ScoreAssignment scoreAssignment) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(scoreAssignment);
	}

	@Override
	public void deleteScoreAssignment(int saId) {
		// TODO Auto-generated method stub
		ScoreAssignment scoreAssignment = (ScoreAssignment) sessionFactory
				.getCurrentSession().load(ScoreAssignment.class, saId);
		if (null != scoreAssignment) {
			sessionFactory.getCurrentSession().delete(scoreAssignment);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScoreAssignment> listScoreAssignmentBystuId(int stuId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from ScoreAssignment sa where sa.student.stuId=:stuId");
		q.setInteger("stuId", stuId);
		return q.list();
	}

	@Override
	public boolean updateScoreAssignment(int saId, String evaluate, double score) {
		// TODO Auto-generated method stub
		try {
			ScoreAssignment scoreAssignment = (ScoreAssignment) sessionFactory
					.getCurrentSession().load(ScoreAssignment.class, saId);
			if (null != scoreAssignment) {
				scoreAssignment.setEvaluate(evaluate);
				scoreAssignment.setScore(score);
				scoreAssignment.setCorrect(1);//ÒÑÅú¸Ã
				sessionFactory.getCurrentSession().update(scoreAssignment);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ScoreAssignment> findAssignment(Integer teaId, int pageNow) {
		// TODO Auto-generated method stub
		/*and s.correct>=0*/
		String hql = "from ScoreAssignment s where s.assignment.teacher.teaId = ?  order by s.assignment.createTime desc";
		String[] parameters = new String[1];
		parameters[0] = teaId + "";
		Session session = sessionFactory.getCurrentSession();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		List<ScoreAssignment> list = dividePage.executeQueryByPage(session,
				hql, parameters, pageNow);
		return list;
	}

	@Override
	public int findAssignment(Integer teaId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from ScoreAssignment s where s.assignment.teacher.teaId = ? and s.correct>=0");
		q.setParameter(0, teaId);
		int sumCount = q.list().size();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		int sumPage = dividePage.getPageCount(sumCount);
		return sumPage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScoreAssignment> findNoAssignment(Integer teaId) {
		// TODO Auto-generated method stub
		List<ScoreAssignment> list = new ArrayList<ScoreAssignment>();
		Query q = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from ScoreAssignment s where s.assignment.teacher.teaId = ? and s.correct<0 order by s.assignment.createTime asc");
		q.setParameter(0, teaId);
		list = q.list();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ScoreAssignment> queryScoreAssignmentByStuId(Integer stuId,
			int pageNow) {
		// TODO Auto-generated method stub
		/*and s.correct>=0*/
		String hql = "from ScoreAssignment s where s.student.stuId = ? and s.correct>=0 order by s.assignment.createTime desc";
		String[] parameters = new String[1];
		parameters[0] = stuId + "";
		Session session = sessionFactory.getCurrentSession();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		List<ScoreAssignment> list = dividePage.executeQueryByPage(session,
				hql, parameters, pageNow);
		return list;
	}

	@Override
	public int queryScoreAssignmentByStuId(Integer stuId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from ScoreAssignment s where s.student.stuId = ? and s.correct>=0 ");
		q.setParameter(0, stuId);
		int sumCount = q.list().size();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		int sumPage = dividePage.getPageCount(sumCount);
		return sumPage;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ScoreAssignment> selectFinishedAssignment(Integer stuId,
			int pageNow) {
		// TODO Auto-generated method stub
		String hql = "from ScoreAssignment s where s.student.stuId = ? order by s.assignment.createTime desc";
		String[] parameters = new String[1];
		parameters[0] = stuId + "";
		Session session = sessionFactory.getCurrentSession();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		List<ScoreAssignment> list = dividePage.executeQueryByPage(session,
				hql, parameters, pageNow);
		return list;
	}

	@Override
	public int selectFinishedAssignment(Integer stuId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from ScoreAssignment s where s.student.stuId = ?");
		q.setParameter(0, stuId);
		int sumCount = q.list().size();
		DivideHibernateUtil dividePage = new DivideHibernateUtil();
		int sumPage = dividePage.getPageCount(sumCount);
		return sumPage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScoreAssignment> queryScoreAssignmentByAssId(Integer assId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from ScoreAssignment sa where sa.assignment.assId=:assId");
		q.setInteger("assId", assId);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ScoreAssignment findscoreAssignment(Integer saId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ScoreAssignment sa where sa.saId=?");
		q.setInteger(0, saId);
		 List<ScoreAssignment> list = q.list();
		return list.get(0);
	}

}
