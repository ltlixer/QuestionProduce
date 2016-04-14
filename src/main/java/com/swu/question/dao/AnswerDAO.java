package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Answer;


public interface AnswerDAO {
	/**
	 * 
	 * @param answer
	 * @return
	 */
	public boolean addAnswer(Answer answer);
	/**
	 * 
	 * @param answerId
	 * @return
	 */
	public boolean deleteAnswer(int answerId);
	/**
	 * 
	 * @param answerId
	 * @return
	 */
	public Answer queryAnswerByAnswerID(int answerId);
	/**
	 * 
	 * @param qid
	 * @param stuId
	 * @return
	 */
	public List<Answer> queryAnswers(int qid,int stuId);
	/**
	 * 
	 * @param qid
	 * @return
	 */
	public List<Answer> queryAnswersByQid(int qid);
	/**
	 * 
	 * @param scoreAssId
	 * @return
	 */
	public List<Answer> queryAnswerByscoreAssId(int scoreAssId);
	/**
	 * 
	 * @param answerId
	 * @param tOrF
	 * @return
	 */
	public boolean updateAnswer(int answerId,String tOrF);
}
