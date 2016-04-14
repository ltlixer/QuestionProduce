package com.swu.question.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.dao.QuestionTypeDAO;
import com.swu.question.entity.Answer;
import com.swu.question.entity.QuestionType;

@Repository
public class QuestionTypeDAOImpl implements QuestionTypeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		try {
			if(queryQuestionType(questionType.getQuestionType())==null){
				sessionFactory.getCurrentSession().save(questionType);
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(questionType);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public QuestionType queryQuestionType(String questionType) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from QuestionType qt where qt.questionType=?");
		q.setParameter(0, questionType);
		@SuppressWarnings("unchecked")
		List<QuestionType> questionTypeList = (List<QuestionType>) q.list();
		if(questionTypeList.size()>0){
			return questionTypeList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<QuestionType> queryQuestionTypes() {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from QuestionType qt");
		@SuppressWarnings("unchecked")
		List<QuestionType> questionTypes = (List<QuestionType>) q.list();
		return questionTypes;
	}

	@Override
	public boolean updateQuestionType(QuestionType questionType) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(questionType);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
