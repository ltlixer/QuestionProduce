package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.ScoreAssignment;

public interface ScoreAssignmentDAO {
	/**
	 * 查询所有的scoreAssignment
	 * 
	 * @return 返回一个scoreAssignment的list
	 */
	public List<ScoreAssignment> listScoreAssignment();

	/**
	 * 
	 * @param scoreAssignment
	 */
	public void addScoreAssignment(ScoreAssignment scoreAssignment);

	/**
	 * 根据saId删除一个scoreAssignment
	 * 
	 * @param saId
	 * @return
	 */
	public void deleteScoreAssignment(int saId);

	/**
	 * 根据stuId查出一个 List<ScoreAssignment>
	 * 
	 * @param stuId
	 * @return
	 */
	public List<ScoreAssignment> listScoreAssignmentBystuId(int stuId);

	/**
	 * 根据saId,更新 evaluate、 score域
	 * 
	 * @param saId
	 * @param evaluate
	 * @param score
	 */
	public boolean updateScoreAssignment(int saId, String evaluate, double score);

	/**
	 * 查询教师没有批改的作业
	 * 
	 * @param teaId
	 * @return
	 */
	public List<ScoreAssignment> findNoAssignment(Integer teaId);

	/**
	 * 查询老师批改过的作业
	 * 
	 * @param teaId
	 * @param pageNow
	 * @return
	 */
	public List<ScoreAssignment> findAssignment(Integer teaId, int pageNow);

	/**
	 * 
	 * @param teaId
	 * @return
	 */
	public int findAssignment(Integer teaId);

	/**
	 * 
	 * @param stuId
	 * @param pageNow
	 * @return
	 */
	public List<ScoreAssignment> queryScoreAssignmentByStuId(Integer stuId,
			int pageNow);

	/**
	 * 
	 * @param stuId
	 * @return
	 */
	public int queryScoreAssignmentByStuId(Integer stuId);

	/**
	 * 
	 * @param assId
	 * @return
	 */
	public List<ScoreAssignment> queryScoreAssignmentByAssId(Integer assId);

	/**
	 * 
	 * @param stuId
	 * @param pageNow
	 * @return
	 */
	public List<ScoreAssignment> selectFinishedAssignment(Integer stuId,
			int pageNow);

	/**
	 * 
	 * @param stuId
	 * @return
	 */
	public int selectFinishedAssignment(Integer stuId);

	/**
	 * 
	 * @param saId
	 * @return
	 */
	public ScoreAssignment findscoreAssignment(Integer saId);
}
