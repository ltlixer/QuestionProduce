package com.swu.question.service;

import java.util.List;
import java.util.Map;

import com.swu.question.entity.Answer;
import com.swu.question.entity.Student;

public interface AnswerService {
	
	/**
	 * 
	 * @param answers
	 * @param answerolds
	 * @param qids
	 * @param assId
	 * @param student
	 * @param useTime
	 * @param list 存放做作业日志时间
	 * @return
	 */
	public boolean addAnswers(String[] answers,String[] answerolds,String[] qids,String assId,Student student,String useTime,Map<String,String> studentCostTime);
	/**
	 * 
	 * @param scoreAssId
	 * @return
	 */
	public List<Answer> queryAnswerByscoreAssId(int scoreAssId);
	/**
	 * 
	 * @param scores
	 * @param sa
	 * @return
	 */
	public String updateScoreAndAnswer(List<Map<String,String>> scores,List<Map<String,String>> sa);

	//以下方法扩展 待用
	public List<Answer> queryAnswers(int qid,int stuId);
	public boolean addAnswer(Answer answer);
	public boolean deleteAnswer(int answerId);
	public Answer queryAnswerByAnswerID(int answerId);
	
	/**
	 * 获取某次作业每个问题的正确率
	 * @param assId
	 * @return
	 */
	public List<Answer> queryStuAnswerCorrectRate(int assId);
}
