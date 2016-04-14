package com.swu.question.service;

import java.util.List;

import com.swu.question.entity.ScoreAssignment;

public interface ScoreAssignmentService {

	/**
	 * 
	 * @param saId
	 * @param evaluate
	 * @param score
	 */
	public void updateScoreAssignment(int saId, String evaluate, int score);
	/**
	 * 
	 * @param saId
	 * @return
	 */
	public ScoreAssignment findscoreAssignment(Integer saId);
	/**
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
	public boolean deleteScoreAssignmentByAssId(Integer assId);
	/**
	 * 
	 * @param stuId
	 * @param pageNow
	 * @return
	 */
	public List<ScoreAssignment> selectFinishedAssignment(Integer stuId, int pageNow);
	/**
	 * 
	 * @param stuId
	 * @return
	 */
	public int selectFinishedAssignment(Integer stuId);
	
	/**
	  待扩展代码
	  */
	public List<ScoreAssignment> findNoAssignment(Integer teaId);
	public boolean addScoreAssignment(ScoreAssignment scoreAssignment);
	public boolean deleteScoreAssignment(int saId);
	
}
