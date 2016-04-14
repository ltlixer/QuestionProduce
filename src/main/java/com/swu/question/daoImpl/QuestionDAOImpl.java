package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.QuestionDAO;
import com.swu.question.entity.Question;

@Repository
public class QuestionDAOImpl implements QuestionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(question);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return false;
		}
		
	}

	@Override
	public boolean deleteQuestion(int qid) {
		// TODO Auto-generated method stub
			
		
		try {
			Question question = (Question) sessionFactory.getCurrentSession().load(
					Question.class, qid);
			if (null != question) {
				sessionFactory.getCurrentSession().delete(question);
			return true;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Question> queryQuestionsByAssID(int assId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
						"from Question q where q.assignment.assId=?");
		q.setParameter(0, assId);
		@SuppressWarnings("unchecked")
		List<Question> list = (List<Question>) q.list();
		return list;
	}

	@Override
	public Question queryQuestion(int qId) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Question q where q.qId=?");
		q.setParameter(0, qId);
		Question question = (Question) q.list().get(0);
		return question;
	}

}
