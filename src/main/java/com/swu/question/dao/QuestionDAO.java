package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Question;

public interface QuestionDAO {
	/**
	 * 
	 * @param question
	 * @return
	 */
	public boolean addQuestion(Question question);
	/**
	 * 
	 * @param qid
	 * @return
	 */
	public boolean deleteQuestion(int qid);
	/**
	 * 
	 * @param assId
	 * @return
	 */
	public List<Question> queryQuestionsByAssID(int assId);
	/**
	 * 
	 * @param qId
	 * @return
	 */
	public Question queryQuestion(int qId);
}
