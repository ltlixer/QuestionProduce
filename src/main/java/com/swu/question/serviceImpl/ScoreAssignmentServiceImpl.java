package com.swu.question.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.dao.ScoreAssignmentDAO;
import com.swu.question.entity.Answer;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.service.ScoreAssignmentService;

@Service
public class ScoreAssignmentServiceImpl implements ScoreAssignmentService {
	@Autowired
	private ScoreAssignmentDAO scoreAssignmentDAO;
	@Autowired
	private AnswerDAO answerDAO;
	
	@Override
	@Transactional
	public List<ScoreAssignment> queryScoreAssignmentByAssId(int assId){
		return scoreAssignmentDAO.queryScoreAssignmentByAssId(assId);
	}
	@Override
	@Transactional
	public void updateScoreAssignment(int saId, String evaluate, int score) {
		// TODO Auto-generated method stub
		scoreAssignmentDAO.updateScoreAssignment(saId, evaluate, score);
	}

	@Override
	@Transactional
	public List<ScoreAssignment> findAssignment(Integer teaId, int pageNow) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.findAssignment(teaId, pageNow);
	}

	@Override
	@Transactional
	public int findAssignment(Integer teaId) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.findAssignment(teaId);
	}

	@Override
	@Transactional
	public List<ScoreAssignment> queryScoreAssignmentByStuId(Integer stuId,
			int pageNow) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.queryScoreAssignmentByStuId(stuId, pageNow);
	}

	@Override
	@Transactional
	public int queryScoreAssignmentByStuId(Integer stuId) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.queryScoreAssignmentByStuId(stuId);
	}

	@Override
	@Transactional
	public boolean deleteScoreAssignmentByAssId(Integer assId) {
		// TODO Auto-generated method stub
		//删除成绩表 先删除 关联的答案
		try {
			List<ScoreAssignment> salist= scoreAssignmentDAO.queryScoreAssignmentByAssId(assId);
			if(salist.size()>0){
				for(int i = 0;i<salist.size();i++){
					int saId = salist.get(i).getSaId();
					List<Answer> answerlist = answerDAO.queryAnswerByscoreAssId(saId);
					if(answerlist.size()>0){
						for(int j = 0;j<answerlist.size();j++){
							System.out.println(answerlist.get(i).getAsswerId());
							answerDAO.deleteAnswer(answerlist.get(j).getAsswerId());
						}
					}
					System.out.println(saId);
					scoreAssignmentDAO.deleteScoreAssignment(saId);
				}
				
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<ScoreAssignment> selectFinishedAssignment(Integer stuId,
			int pageNow) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.selectFinishedAssignment(stuId, pageNow);
	}

	@Override
	@Transactional
	public int selectFinishedAssignment(Integer stuId) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.selectFinishedAssignment(stuId);
	}

	@Override
	public ScoreAssignment findscoreAssignment(Integer saId) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.findscoreAssignment(saId);
	}
	
	
	/*@Override
	@Transactional
	public List<ScoreAssignment> listScoreAssignment() {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.listScoreAssignment();
	}*/

	@Override
	@Transactional
	public boolean addScoreAssignment(ScoreAssignment scoreAssignment) {
		// TODO Auto-generated method stub
		try {
			scoreAssignment.setScore(-1);
			scoreAssignment.setCreateTime(new Date());
			scoreAssignmentDAO.addScoreAssignment(scoreAssignment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteScoreAssignment(int saId) {
		// TODO Auto-generated method stub
		try {
			scoreAssignmentDAO.deleteScoreAssignment(saId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	@Transactional
	public List<ScoreAssignment> findNoAssignment(Integer teaId) {
		// TODO Auto-generated method stub
		return scoreAssignmentDAO.findNoAssignment(teaId);
	}


}
