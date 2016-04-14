package com.swu.question.dao;

import java.util.List;
import java.util.Map;

import com.swu.question.entity.Word;


public interface WordDAO {
	public void insertWord(Word word);
	public void updateWord(Word word);
	public Word getWord(String newWord);
	public List<Word> getWordList();
	public List<Word> getWordListByMap(Map<String,Object> map);
	public int getWordCount();
	public void deletWord();
	/**
	 * 获取某个频段的所有字
	 * @param grade
	 * @return
	 */
	public List<Word> getWordListByFrequency(String grade);
}
