package com.swu.question.service;

import java.util.List;

import com.swu.question.entity.Question;
import com.swu.question.entity.QuestionType;

public interface QuestionService {
	public boolean addQuestion(Question question);
	/**
	 * 删除问题前 先删除答案
	 * @param qid
	 * @return
	 */
	public boolean deleteQuestion(int qid);
	/**
	 * 根据AssId删除问题
	 * @param assId
	 * @return
	 */
	public boolean deleteQuestionByAssId(int assId);
	/**
	 * 
	 * @param assId
	 * @return
	 */
	public List<Question> queryQuestionsByassId(int assId);
	/**
	 * 获取所有问题类型
	 * @return
	 */
	public List<QuestionType> queryQuestionTypes();
	/**
	 * 添加默认问题类型
	 * @return
	 */
	public boolean addQuestionTypes();
}
