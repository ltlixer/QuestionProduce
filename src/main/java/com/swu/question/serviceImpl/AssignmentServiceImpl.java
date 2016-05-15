package com.swu.question.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.AssignmentDAO;
import com.swu.question.dao.LogDAO;
import com.swu.question.dao.QuestionDAO;
import com.swu.question.dao.ScoreAssignmentDAO;
import com.swu.question.dao.StudentDAO;
import com.swu.question.dao.TeacherDAO;
import com.swu.question.dao.TextDAO;
import com.swu.question.entity.Assignment;
import com.swu.question.entity.Course;
import com.swu.question.entity.Distracter;
import com.swu.question.entity.Log;
import com.swu.question.entity.Question;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.entity.Teacher;
import com.swu.question.entity.Text;
import com.swu.question.service.AssignmentService;

import net.sf.json.JSONArray;

@Service
public class AssignmentServiceImpl implements AssignmentService {
	@Autowired
	private AssignmentDAO assignmentDAO;
	@Autowired
	private ScoreAssignmentDAO scoreAssignmentDAO;
	@Autowired
	private TeacherDAO teachetDAO;
	@Autowired
	private TextDAO textDAO;
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private LogDAO logDAO;

	@Override
	@Transactional
	public List<Assignment> listAssignment() {
		// TODO Auto-generated method stub
		return assignmentDAO.listAssignment();
	}

	@Override
	@Transactional
	public boolean addAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		try {
			/*
			 * assignment.setCreateTime(new Date());
			 * assignmentDAO.addAssignment(assignment);
			 */
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean addAssignment(List<Map<String, String>> contents,
			Teacher teacher, List<Map<String, String>> ass,List<Map<String,String>> logs) {
		// TODO Auto-generated method stub
		boolean isSuccess = true;
		String textId = ass.get(0).get("textId");
		String assTime = ass.get(0).get("assTime");
		String startDate = ass.get(0).get("startDate");
		String assName = ass.get(0).get("assName");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = null;
		try {
			date = format.parse(startDate);
			Text text = textDAO.queryText(Integer.parseInt(textId));
			Assignment assignment1 = new Assignment();
			Assignment assignment2 = new Assignment();//选择题作业
			assignment1.setAssName(assName+"-选择题");
			assignment1.setAssTime(Integer.parseInt(assTime));
			assignment1.setStartDate(date);
			assignment1.setCreateTime(new Date());
			assignment1.setTeacher(teacher);
			assignment1.setText(text);
			assignment2.setAssName(assName+"-填空题");
			assignment2.setAssTime(Integer.parseInt(assTime));
			assignment2.setStartDate(date);
			assignment2.setCreateTime(new Date());
			assignment2.setTeacher(teacher);
			assignment2.setText(text);
			
			for (int index = 0; index < contents.size(); index++) {
				Map<String, String> map = contents.get(index);
				Question question = new Question();
				String sentence = map.get("sentence");
				String questionStr = map.get("question");
				String questionType = map.get("questiontype");
				String answer = map.get("answer");
				question.setAnswer(answer);
				question.setSentence(sentence);
				question.setQuestion(questionStr);
				if(questionType.equals("什么样")||questionType.equals("怎样")||questionType.equals("原因结果")){
					question.setQuestionType("deeper");
				}else if(questionType.equals("原始问题")){
					question.setQuestionType("original");
				}else if(questionType.equals("选择题")){
					question.setQuestionType("multiplechoice");
				}else{
					question.setQuestionType("factoid");
				}
				if(question.getQuestionType()=="multiplechoice"){
					assignmentDAO.addAssignment(assignment1);
					question.setAssignment(assignment1);
					if(map.get("distracter")!=null && !"".equals(map.get("distracter"))){
						JSONArray json=JSONArray.fromObject(map.get("distracter"));
						Object[] distracters = json.toArray();
						Set<Distracter> distracterSet = new HashSet<Distracter>();
						for (int i = 0; i < distracters.length; i++) {
							if(""!=distracters[i].toString() && distracters[i].toString()!=null)
								distracterSet.add(new Distracter(distracters[i].toString(),question));
						}
						distracterSet.add(new Distracter(answer,question));
						question.setDistracter(distracterSet);
					}
				}else{
					assignmentDAO.addAssignment(assignment2);
					question.setAssignment(assignment2);
				}
				
				isSuccess = questionDAO.addQuestion(question);
			}
			if (isSuccess == false){
				return false;
			}else{
				//记录日志
				String multiplechoiceStartTime = logs.get(0).get("multiplechoiceStartTime");
				String multiplechoiceEndTime = logs.get(0).get("multiplechoiceEndTime");
				if(!multiplechoiceStartTime.equals("")){
					Log log = new Log();
					log.setAssignment(assignment1);
					log.setStartTime(format.parse(multiplechoiceStartTime));
					log.setEndTime(format.parse(multiplechoiceEndTime));
					log.setQuestionType("multiplechoice");
					log.setTeaId(teacher.getTeaId());
					log.setUser(teacher.getTeaName());
					logDAO.addLog(log);
				}
				String factoidStartTime = logs.get(0).get("factoidStartTime");
				String factoidEndTime = logs.get(0).get("factoidEndTime");
				if(!factoidStartTime.equals("")){
					Log log = new Log();
					log.setAssignment(assignment2);
					log.setStartTime(format.parse(factoidStartTime));
					log.setEndTime(format.parse(factoidEndTime));
					log.setQuestionType("factoid");
					log.setTeaId(teacher.getTeaId());
					log.setUser(teacher.getTeaName());
					logDAO.addLog(log);
				}
				String deeperStartTime = logs.get(0).get("deeperStartTime");
				String deeperEndTime = logs.get(0).get("deeperEndTime");
				if(!deeperStartTime.equals("")){
					Log log = new Log();
					log.setAssignment(assignment2);
					log.setStartTime(format.parse(deeperStartTime));
					log.setEndTime(format.parse(deeperEndTime));
					log.setQuestionType("deeper");
					log.setTeaId(teacher.getTeaId());
					log.setUser(teacher.getTeaName());
					logDAO.addLog(log);
				}
				String originalStartTime = logs.get(0).get("originalStartTime");
				String originalEndTime = logs.get(0).get("originalEndTime");
				if(!originalStartTime.equals("")){
					Log log = new Log();
					log.setAssignment(assignment2);
					log.setStartTime(format.parse(originalStartTime));
					log.setEndTime(format.parse(originalEndTime));
					log.setQuestionType("original");
					log.setTeaId(teacher.getTeaId());
					log.setUser(teacher.getTeaName());
					logDAO.addLog(log);
				}
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	@Transactional
	public boolean deleteAssignment(int assId) {
		// TODO Auto-generated method stub
		try {
			logDAO.deleteLogByAssId(assId);
			assignmentDAO.deleteAssignment(assId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<Assignment> selectAssignmentByteaId(int teaId, int pageNow) {
		// TODO Auto-generated method stub
		return assignmentDAO.selectAssignmentByteaId(teaId, pageNow);
	}

	@Override
	@Transactional
	public List<Assignment> listAllAssignment(int courseId,
			int stuId, String findAss) {
		// TODO Auto-generated method stub
		// 查询该学生已完成的作业
		List<ScoreAssignment> finishList = scoreAssignmentDAO
				.listScoreAssignmentBystuId(stuId);
		// 所有该课程的作业
		List<Assignment> allList = new ArrayList<Assignment>();
		List<Assignment> noFinishList = new ArrayList<Assignment>();
		allList = assignmentDAO.selectAssignmentByCourseId(courseId, findAss);
		
		// 过滤已做过的作业
		if (finishList != null && finishList.size() > 0) {
			if (allList != null && allList.size() > 0) {
				for (int i = 0; i < allList.size(); i++) {
					boolean finish = false;
					for (int j = 0; j < finishList.size(); j++) {
						int id1 = allList.get(i).getAssId();
						int id2 = finishList.get(j).getAssignment().getAssId();
						if (id1==id2) {
							finish = true;
							break;
						}
					}
					if (!finish) {
						noFinishList.add(allList.get(i));
					}
				}
				return noFinishList;
			} else {
				return null;
			}
		} else {
			return allList;
		}
	}

	/*
	 * @Override
	 */
	@Override
	@Transactional
	public Assignment getAssignment(Integer assId) {
		List<Assignment> list = assignmentDAO.listAssignment();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAssId().equals(assId)) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public int countAssignmentByTeaId(Integer teaId) {
		// TODO Auto-generated method stub
		return assignmentDAO.countAssignmentByTeaId(teaId);
	}

	@Override
	@Transactional
	public List<Assignment> listAllAssignment(Integer stuId) {
		// TODO Auto-generated method stub

		return assignmentDAO.listAllAssignment(stuId);
	}

	@Override
	public List<Assignment> queryAssignmentByTextId(int textId) {
		// TODO Auto-generated method stub
		return assignmentDAO.queryAssignmentByTextId(textId);
	}

	@Override
	public List<Assignment> listAllUndoneAssignment(int stuId) {
		// TODO Auto-generated method stub
		Set<Course> stuCourses = studentDao.listCourse(stuId);
		List<Assignment> allUndoneAssignment = new ArrayList<Assignment>();
		for(Course c:stuCourses){
			List<Assignment> courseAssignment = listAllAssignment(c.getCourseId(), stuId, null);
			if(courseAssignment!=null)
				allUndoneAssignment.addAll(courseAssignment);
		}
		return allUndoneAssignment;
	}

	@Override
	public List<Assignment> queryTextUndoneAssignment(int stuId, int textId) {
		// TODO Auto-generated method stub
		// 查询该学生已完成的作业
		List<ScoreAssignment> finishList = scoreAssignmentDAO
				.listScoreAssignmentBystuId(stuId);
		// 所有该作业下的作业
		List<Assignment> allList = queryAssignmentByTextId(textId);
		List<Assignment> noFinishList = new ArrayList<Assignment>();
		
		// 过滤已做过的作业
		if (finishList != null && finishList.size() > 0) {
			if (allList != null && allList.size() > 0) {
				for (int i = 0; i < allList.size(); i++) {
					boolean finish = false;
					for (int j = 0; j < finishList.size(); j++) {
						int id1 = allList.get(i).getAssId();
						int id2 = finishList.get(j).getAssignment().getAssId();
						if (id1==id2) {
							finish = true;
							break;
						}
					}
					if (!finish) {
						noFinishList.add(allList.get(i));
					}
				}
				return noFinishList;
			} else {
				return null;
			}
		} else {
			return allList;
		}
	}

}
