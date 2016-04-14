package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Text;

public interface TextDAO {
	/**
	 * 查询所有的TeXt
	 * 
	 * @return
	 */
	public List<Text> listText();

	public List<Text> listTextByCourseId(int courseId);

	/**
	 * 根据课文的id查询课文
	 * 
	 * @param textId
	 * @return
	 */
	public Text queryText(int textId);

	/**
	 * 根据老师的id查询课文
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Text> queryTextByTeas(int teaId, int pageNow);

	public int countqueryTextByTeas(int teaId);

	/**
	 * 根据课程ID 和 查找的课文标题 统计课文的总数
	 * 
	 * @param teaId
	 * @return
	 */
	public int countTextByCourseId(String courseId, String findText);

	/**
	 * 根据课文Id的集合 和 查找的课文标题 查询课文
	 * 
	 * @param teaIds
	 * @param pageNow
	 * @return
	 */
	public List<Text> listTextByCourseIdDividePage(String courseId, int pageNow, String findText);

	/**
	 * @param 添加一个Text
	 * @return true 或false
	 */
	public boolean addText(Text text);

	/**
	 * 根据textId删除一个Text
	 * 
	 * @param textId
	 * @return
	 */
	public void deleteText(int textId);
}
