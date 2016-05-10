package com.swu.question.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.dao.AssignmentDAO;
import com.swu.question.dao.LogDAO;
import com.swu.question.dao.QuestionDAO;
import com.swu.question.dao.ScoreAssignmentDAO;
import com.swu.question.entity.Answer;
import com.swu.question.entity.Assignment;
import com.swu.question.entity.Log;
import com.swu.question.entity.Question;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.entity.Student;
import com.swu.question.service.AnswerService;
import com.swu.question.util.Similarity;

@Service
public class AnswerServiceImpl implements AnswerService {
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
	public boolean addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return answerDAO.addAnswer(answer);
	}

	@Override
	@Transactional
	public boolean deleteAnswer(int answerId) {
		// TODO Auto-generated method stub
		return answerDAO.deleteAnswer(answerId);
	}

	@Override
	@Transactional
	public Answer queryAnswerByAnswerID(int answerId) {
		// TODO Auto-generated method stub
		return answerDAO.queryAnswerByAnswerID(answerId);
	}

	@Override
	@Transactional
	public List<Answer> queryAnswers(int qid, int stuId) {
		// TODO Auto-generated method stub
		return answerDAO.queryAnswers(qid, stuId);
	}

	/**
	 * 向数据库存储 答案 存储两个表 答案表(answer) 作业情（assigmentScore）表
	 */
	@Override
	@Transactional
	public boolean addAnswers(String[] answers, String[] answerolds,
			String[] qids, String assId, Student student, String useTime,
			Map<String,String> studentCostTime) {
		// TODO Auto-generated method stub
		try {
			int right = 0;
			double score = 0;
			for (int i = 0; i < answers.length; i++) {
				double similarity = new Similarity().SimilarDegree(answers[i],
						answerolds[i]);
				if (similarity > 0.6) {
					right++;
				}
			}
			score = ((double) right / answers.length) * 100;
			ScoreAssignment scoreAssignment = new ScoreAssignment();
			Assignment assignment = assignmentDAO.queryAssignment(Integer
					.parseInt(assId));
			scoreAssignment.setAssignment(assignment);
			scoreAssignment.setCreateTime(new Date());
			scoreAssignment.setStudent(student);
			scoreAssignment.setUseTime(Integer.parseInt(useTime));
			scoreAssignment.setScore(score);
			String evaluate = "";
			if (score > 95) {
				evaluate = "真棒，再接再厉！";
			} else if (score > 90) {
				evaluate = "真棒，争取下次更好！";
			} else if (score > 70) {
				evaluate = "良好，加油！";
			} else if (score > 60) {
				evaluate = "及格了，加油！希望下次更好哦！";
			} else if (score > 40) {
				evaluate = "在努力一把，下次会更好的！";
			} else if (score == 0) {
				evaluate = "作业要用心啊！";
			} else {
				evaluate = "真遗憾，本次作业没做好！";
			}
			scoreAssignment.setEvaluate(evaluate);
			scoreAssignment.setCorrect(-1);
			scoreAssignmentDAO.addScoreAssignment(scoreAssignment);
			for (int i = 0; i < answers.length; i++) {
				Question question = questionDAO.queryQuestion(Integer
						.parseInt(qids[i]));
				Answer answer = new Answer();
				answer.setAnswer(answers[i]);
				Similarity sim = new Similarity();
				double similarity = sim
						.SimilarDegree(answers[i], answerolds[i]);
				if (similarity > 0.6) {
					answer.settOrF("T");
				} else {
					answer.settOrF("F");
				}
				answer.setSimilarity(sim.similarityResult(similarity));
				answer.setQuestion(question);
				answer.setScoreAssignment(scoreAssignment);
				answerDAO.addAnswer(answer);
			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// 记录学生做作业的日志
			if(!studentCostTime.get("multiplechoiceStartTime").isEmpty()){
				Log log = new Log();
				log.setAssignment(assignment);
				log.setStartTime(format.parse(studentCostTime.get("multiplechoiceStartTime")));
				log.setEndTime(format.parse(studentCostTime.get("multiplechoiceEndTime")));
				log.setUseTime(log.getEndTime().getTime()-log.getStartTime().getTime());
				log.setQuestionType("选择题");
				log.setStuId(student.getStuId());
				log.setUser(student.getStuName());
				logDAO.addLog(log);
			}
			if(!studentCostTime.get("factoidStartTime").isEmpty()){
				Log log = new Log();
				log.setAssignment(assignment);
				log.setStartTime(format.parse(studentCostTime.get("factoidStartTime")));
				log.setEndTime(format.parse(studentCostTime.get("factoidEndTime")));
				log.setUseTime(log.getEndTime().getTime()-log.getStartTime().getTime());
				log.setQuestionType("事实类问题");
				log.setStuId(student.getStuId());
				log.setUser(student.getStuName());
				logDAO.addLog(log);
			}
			if(!studentCostTime.get("deeperStartTime").isEmpty()){
				Log log = new Log();
				log.setAssignment(assignment);
				log.setStartTime(format.parse(studentCostTime.get("deeperStartTime")));
				log.setEndTime(format.parse(studentCostTime.get("deeperEndTime")));
				log.setUseTime(log.getEndTime().getTime()-log.getStartTime().getTime());
				log.setQuestionType("深层次问题");
				log.setStuId(student.getStuId());
				log.setUser(student.getStuName());
				logDAO.addLog(log);
			}
			if(!studentCostTime.get("originalStartTime").isEmpty()){
				Log log = new Log();
				log.setAssignment(assignment);
				log.setStartTime(format.parse(studentCostTime.get("originalStartTime")));
				log.setEndTime(format.parse(studentCostTime.get("originalEndTime")));
				log.setUseTime(log.getEndTime().getTime()-log.getStartTime().getTime());
				log.setQuestionType("原始问题");
				log.setStuId(student.getStuId());
				log.setUser(student.getStuName());
				logDAO.addLog(log);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	@Transactional
	public List<Answer> queryAnswerByscoreAssId(int scoreAssId) {
		// TODO Auto-generated method stub
		return answerDAO.queryAnswerByscoreAssId(scoreAssId);
	}

	@Override
	@Transactional
	public String updateScoreAndAnswer(List<Map<String, String>> scores,
			List<Map<String, String>> sa) {
		// TODO Auto-generated method stub
		boolean b = false;
		for (int index = 0; index < scores.size(); index++) {
			Map<String, String> map = scores.get(index);
			String answerId = map.get("answerId");
			String tOrF = map.get("tOrF");
			b = answerDAO.updateAnswer(Integer.parseInt(answerId), tOrF);
		}
		if (b) {
			String saId = sa.get(0).get("saId");
			String evaluate = sa.get(0).get("evaluate");
			String score = sa.get(0).get("score");
			b = scoreAssignmentDAO
					.updateScoreAssignment(Integer.parseInt(saId), evaluate,
							Double.parseDouble(score));
		}
		if (b) {
			return "success";
		}
		return "error";
	}

	@Override
	@Transactional
	public List<Answer> queryStuAnswerCorrectRate(int assId) {
		// TODO Auto-generated method stub
		List<Question> questionList = questionDAO.queryQuestionsByAssID(assId);
		List<Answer> stuAnswerCorrectRate = new ArrayList<Answer>();
		for(Question q:questionList){
			List<Answer> answerList = answerDAO.queryAnswersByQid(q.getqId());
			Answer stuAnswer = new Answer();
			int answerSimilaritySum = 0;
			for(Answer a:answerList){
				int answerSimilarity = Integer.parseInt(a.getSimilarity().split("%")[0]);
				answerSimilaritySum += answerSimilarity;
			}
			int answerAverage = answerSimilaritySum/answerList.size();
			stuAnswer.setAsswerId(q.getqId());
			stuAnswer.setSimilarity(answerAverage+"");
			stuAnswerCorrectRate.add(stuAnswer);
		}
		return stuAnswerCorrectRate;
	}

}
