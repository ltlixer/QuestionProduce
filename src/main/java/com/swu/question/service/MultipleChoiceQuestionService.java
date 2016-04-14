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

	
}
