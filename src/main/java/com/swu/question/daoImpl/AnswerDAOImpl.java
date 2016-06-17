package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.entity.Answer;

@Repository
public class AnswerDAOImpl implements AnswerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(answer);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAnswer(int answerId) {
		// TODO Auto-generated method stub
		try {
			Answer answer = (Answer) sessionFactory.getCurrentSession().load(
					Answer.class, answerId);
			if (null != answer) {
				sessionFactory.getCurrentSession().delete(answer);
			return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Answer queryAnswerByAnswerID(int answerId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Answer a where a.answerId=?");
		q.setParameter(0, answerId);
		Answer answer = (Answer) q.list().get(0);
		return answer;
	}
	 
	@Override
	public List<Answer> queryAnswers(int qid, int stuId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Answer a where a.question.qId=? and a.scoreAssignment.student.stuId =?");
		q.setParameter(0, qid);
		q.setParameter(1, stuId);
		 @SuppressWarnings("unchecked")
		List<Answer> list = (List<Answer>) q.list();
		return list;
	}

	@Override
	public List<Answer> queryAnswersByQid(int qid) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Answer a where a.question.qId=?");
		q.setParameter(0, qid);
		 @SuppressWarnings("unchecked")
		List<Answer> list = (List<Answer>) q.list();
		return list;
	}

	@Override
	public List<Answer> queryAnswerByscoreAssId(int scoreAssId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Answer a where a.scoreAssignment.saId=?");
		q.setParameter(0, scoreAssId);
		 @SuppressWarnings("unchecked")
		List<Answer> list = (List<Answer>) q.list();
		return list;
	}

	@Override
	public boolean updateAnswer(int answerId, String tOrF) {
		// TODO Auto-generated method stub
		try {
			Answer answer = (Answer) sessionFactory
					.getCurrentSession().load(Answer.class, answerId);
			if (null != answer) {
				answer.settOrF(tOrF);
				sessionFactory.getCurrentSession().update(answer);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
