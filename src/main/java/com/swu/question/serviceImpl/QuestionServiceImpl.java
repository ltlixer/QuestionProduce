package com.swu.question.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.dao.QuestionDAO;
import com.swu.question.dao.QuestionTypeDAO;
import com.swu.question.entity.Question;
import com.swu.question.entity.QuestionType;
import com.swu.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private AnswerDAO answerDAO;
	@Autowired
	private QuestionTypeDAO questionTypeDAO;
	@Override
	@Transactional 
	public boolean addQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionDAO.addQuestion(question);
	}
	@Override
	@Transactional 
	public boolean deleteQuestionByAssId(int assId){
		try {
			
			List<Question> list = questionDAO.queryQuestionsByAssID(assId);
			for(int i = 0;i<list.size();i++){
				int qid = list.get(i).getqId();
				questionDAO.deleteQuestion(qid);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	@Override
	@Transactional 
	public boolean deleteQuestion(int qid) {
		// TODO Auto-generated method stub
		return questionDAO.deleteQuestion(qid);
	}

	@Override
	@Transactional 
	public List<Question> queryQuestionsByassId(int assId) {
		// TODO Auto-generated method stub
		return questionDAO.queryQuestionsByAssID(assId);
	}
	@Override
	public List<QuestionType> queryQuestionTypes() {
		// TODO Auto-generated method stub
		List<QuestionType> questionTypes = questionTypeDAO.queryQuestionTypes();
		if(questionTypes.isEmpty()){
			addQuestionTypes();
			questionTypes = queryQuestionTypes();
		}else{
			return questionTypes;
		}
		return null;
	}
	@Override
	public boolean addQuestionTypes() {
		// TODO Auto-generated method stub
		QuestionType qt1 = new QuestionType("multiplechoice", "选择题");
		boolean b1 = questionTypeDAO.addQuestionType(qt1);
		QuestionType qt2 = new QuestionType("factoid", "事实类问题");
		boolean b2 = questionTypeDAO.addQuestionType(qt2);
		QuestionType qt3 = new QuestionType("deeper", "深层次问题");
		boolean b3 = questionTypeDAO.addQuestionType(qt3);
		QuestionType qt4 = new QuestionType("original", "原始问题");
		boolean b4 = questionTypeDAO.addQuestionType(qt4);
		return b1&&b2&&b3&&b4;
	}
}
