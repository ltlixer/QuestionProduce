package com.swu.question.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.dao.AssignmentDAO;
import com.swu.question.dao.LogDAO;
import com.swu.question.dao.QuestionDAO;
import com.swu.question.dao.ScoreAssignmentDAO;
import com.swu.question.entity.Log;
import com.swu.question.service.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private AnswerDAO answerDAO;

	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private ScoreAssignmentDAO scoreAssignmentDAO;
	@Autowired
	private AssignmentDAO assignmentDAO;
	@Autowired
	private LogDAO logDAO;

	
	@Override
	@Transactional
	public List<Log> queryStudentCostTime(int assId) {
		// TODO Auto-generated method stub
		List<Log> logList = logDAO.queryLogsByAssId(assId);
		Set<String> logStu = new HashSet<String>();
		List<Log> studentCostTimeLog = new ArrayList<Log>();
		for(Log l:logList){
			if(l.getStuId()!=null){
				if(!logStu.add(l.getStuId().toString())){
					for(int i=0;i<studentCostTimeLog.size();i++){
						if(studentCostTimeLog.get(i).getStuId().equals(l.getStuId())){
							long t = studentCostTimeLog.get(i).getUseTime() + l.getUseTime();
							studentCostTimeLog.get(i).setUseTime(t);
							break;
						}
					}
				}else{
					logStu.add(l.getStuId().toString());
					Log log = new Log();
					log.setUser(l.getUser());
					log.setStuId(l.getStuId());
					log.setUseTime(l.getUseTime());
					studentCostTimeLog.add(log);
				}
			}
		}
		return studentCostTimeLog;
	}

}
