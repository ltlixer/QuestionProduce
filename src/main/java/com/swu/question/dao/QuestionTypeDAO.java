package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Answer;
import com.swu.question.entity.QuestionType;


public interface QuestionTypeDAO {
	
	public boolean addQuestionType(QuestionType questionType);
	
	public boolean deleteQuestionType(QuestionType questionType);
	
	public QuestionType queryQuestionType(String questionType);

	public List<QuestionType> queryQuestionTypes();
	
	public boolean updateQuestionType(QuestionType questionType);
}
