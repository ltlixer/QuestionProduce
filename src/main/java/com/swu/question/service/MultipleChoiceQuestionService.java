package com.swu.question.service;

import java.util.List;

import com.swu.question.entity.Question;

public interface MultipleChoiceQuestionService {
	
	/**
	 * 生成多项选择题问题
	 * @param textId 文章Id
	 * @return
	 */
	public List<Question> createMultipleChoiceQuestion(int textId,String path);
	/**
	 * 1：部首-结构-拼音-笔画-语意
	 * @param textId
	 * @return
	 */
	public List<Question> generateChoiceQuestion1(int textId);
	/**
	 * 2：部首-结构-拼音
	 * @param textId
	 * @return
	 */
	public List<Question> generateChoiceQuestion2(int textId);
	/**
	 * 3：部首-结构-笔画
	 * @param textId
	 * @return
	 */
	public List<Question> generateChoiceQuestion3(int textId);
	/**
	 * 4：部首-结构-语意
	 * @param textId
	 * @return
	 */
	public List<Question> generateChoiceQuestion4(int textId);
	public void addHsk(String path);

	
}
