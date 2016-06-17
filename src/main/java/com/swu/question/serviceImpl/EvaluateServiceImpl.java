package com.swu.question.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.EvaluateDAO;
import com.swu.question.dao.LogDAO;
import com.swu.question.dao.StudentDAO;
import com.swu.question.dao.TextDAO;
import com.swu.question.dto.StudentAnswerAnalysis;
import com.swu.question.entity.Answer;
import com.swu.question.entity.Evaluate;
import com.swu.question.entity.Log;
import com.swu.question.entity.Question;
import com.swu.question.entity.Student;
import com.swu.question.entity.Text;
import com.swu.question.service.AnswerService;
import com.swu.question.service.AssignmentService;
import com.swu.question.service.EvaluateService;
import com.swu.question.service.QuestionService;
import com.swu.question.service.ScoreAssignmentService;
import com.swu.question.util.DeleteFile;
import com.swu.question.util.DivideHibernateUtil;
import com.swu.question.util.ExcelBean;
import com.swu.question.util.UploadDownloadFile;

@Service
public class EvaluateServiceImpl implements EvaluateService {
	@Autowired
	private EvaluateDAO evaluateDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private TextDAO textDAO;
	@Autowired
	private LogDAO logDAO;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ScoreAssignmentService scoreAssignmentService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private AssignmentService assignmentService;
	@Override
	@Transactional
	public boolean addEvaluate(Evaluate evaluate) {
		// TODO Auto-generated method stub
		return evaluateDAO.addEvaluate(evaluate);
	}

/*	@Override
	@Transactional
	public List<Evaluate> queryEvaluateByTextId(int stuId) {
		// TODO Auto-generated method stub
		return evaluateDAO.queryEvaluateByTextId(stuId);
	}*/

	@Override
	@Transactional
	public boolean addEvaluateJson(List<Map<String, String>> evaluates,
			String textId, Student student) {
		// TODO Auto-generated method stub
		try {
			Text text = textDAO.queryText(Integer.parseInt(textId));
			boolean re = false;
			for (int index = 0; index < evaluates.size(); index++) {
				Map<String, String> map = evaluates.get(index);
				Evaluate evaluate = new Evaluate();
				String sentenceId = map.get("sentenceid");
				String sentecestr = map.get("sentecestr");
				String quest = map.get("quest");
				String answer = map.get("answer");
				String feature1 = map.get("Feature1");
				String feature2 = map.get("Feature2");
				String feature3 = map.get("Feature3");
				String feature4 = map.get("Feature4");
				String feature5 = map.get("Feature5");
				String tOrF = map.get("tOrF");
				String desc = map.get("desc");
				evaluate.setSentenceId(Integer.parseInt(sentenceId));
				evaluate.setSentece(sentecestr);
				evaluate.setQuestion(quest);
				evaluate.setAnswer(answer);
				evaluate.setFeature1(Integer.parseInt(feature1));
				evaluate.setFeature2(Integer.parseInt(feature2));
				evaluate.setFeature3(Integer.parseInt(feature3));
				evaluate.setFeature4(Integer.parseInt(feature4));
				evaluate.setFeature5(Integer.parseInt(feature5));
				evaluate.settOrF(Integer.parseInt(tOrF));
				evaluate.setDescription(desc);
				evaluate.setText(text);
				evaluate.setStudent(student);
				re = evaluateDAO.addEvaluate(evaluate);
			}
			if(re==false){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
	
	
	
	//评估使用
		@Override
		@Transactional
		public List<Text> listTexts(int courseId, int stuId) {
			// TODO Auto-generated method stub
			List<Text> allList=textDAO.listTextByCourseId(courseId);
					//textDAO.listText();
			List<Text> noevluatedList = new ArrayList<Text>();
			List<Integer> textIds = evaluateDAO.queryEvaluateByStuId(stuId);
			for(int i=0;i<allList.size();i++){
				boolean isEvluated = false;//该学生是否评估
				for(int j = 0;j<textIds.size();j++){
					int id1 =allList.get(i).getTextId();
					int id2 =textIds.get(j);
					if(id1==id2){
						isEvluated = true;
						break;
					}
				}
				if(!isEvluated){
					noevluatedList.add(allList.get(i));
				}
			}
			return noevluatedList;
		}

		@Override
		@Transactional
		public int countListTexts(int courseId, int stuId) {
			// TODO Auto-generated method stub
			List<Text> allList=  textDAO.listTextByCourseId(courseId);
			List<Text> noevluatedList = new ArrayList<Text>();
			List<Integer> textIds = evaluateDAO.queryEvaluateByStuId(stuId);
			for(int i=0;i<allList.size();i++){
				boolean isEvluated = false;//该学生是否评估
				for(int j = 0;j<textIds.size();j++){
					int id1 =allList.get(i).getTextId();
					int id2 =textIds.get(j);
					if(id1==id2){
						isEvluated = true;
						break;
					}
				}
				if(!isEvluated){
					noevluatedList.add(allList.get(i));
				}
			}
			DivideHibernateUtil dividePage = new DivideHibernateUtil();
			int sumPage = dividePage.getPageCount(noevluatedList.size());
			return sumPage;
		}

		@Override
		@Transactional
		public List<Text> listTextsEvaluated(int stuId) {
			// TODO Auto-generated method stub
			List<Text> allList=  textDAO.listText();
			List<Text> allListevluated = new ArrayList<Text>();
			List<Integer> textIds = evaluateDAO.queryEvaluateByStuId(stuId);
			boolean isEvluated =false;
			for(int i=0;i<allList.size();i++){
				isEvluated = false;//该学生是否评估
				for(int j = 0;j<textIds.size();j++){
					int id1 =allList.get(i).getTextId();
					int id2 =textIds.get(j);
					if(id1==id2){
						isEvluated = true;
						break;
					}
				}
				if(isEvluated){
					allListevluated.add(allList.get(i));
				}
			}
			return allListevluated;
		}

		@Override
		@Transactional
		public int countlistTextsEvaluated(int stuId) {
			// TODO Auto-generated method stub
			List<Text> allList=  textDAO.listText();
			List<Text> allListevluated = new ArrayList<Text>();
			List<Integer> textIds = evaluateDAO.queryEvaluateByStuId(stuId);
			for(int i=0;i<allList.size();i++){
				boolean isEvluated = false;//该学生是否评估
				for(int j = 0;j<textIds.size();j++){
					int id1 =allList.get(i).getTextId();
					int id2 =textIds.get(j);
					if(id1==id2){
						isEvluated = true;
						break;
					}
				}
				if(isEvluated){
					allListevluated.add(allList.get(i));
				}
			}
			DivideHibernateUtil dividePage = new DivideHibernateUtil();
			int sumPage = dividePage.getPageCount(allListevluated.size());
			return sumPage;
		}
		@Override
		@Transactional
		public int countTextByCourseId(String courseId) {
			// TODO Auto-generated method stub
				return evaluateDAO.countTextByCourseId(courseId);
		}
		@Override
		@Transactional
		public List<Text> listEvaluated(int courseId){
			return evaluateDAO.listEvaluated(courseId);
		}

		
		@Override
		@Transactional
		public boolean deleteEvaluate(int textId, int stuId) {
			// TODO Auto-generated method stub
			return evaluateDAO.deleteEvaluatebyStu(textId, stuId);
		}
		
		
		@Override
		@Transactional
		public boolean downloadEvaluated(String[] courseIds,HttpServletResponse response, String path,
				String fileName) {
			// TODO Auto-generated method stub
			List<Evaluate> listAll = new ArrayList<Evaluate>();
			for(int i = 0;i<courseIds.length;i++){
				List<Evaluate> list=evaluateDAO.listEvaluatedDownload(courseIds[0]);
				for(int j=0;list!=null&&j<list.size();j++){
					listAll.add(list.get(j));
				}
			}
			String fileNamesave = new ExcelBean().setValues(path, fileName, listAll);
			UploadDownloadFile uploadFile = new UploadDownloadFile();
			try {
				String re =  uploadFile.download(response,path, fileNamesave);
				System.out.println("下载："+re);
				//删除文件
				DeleteFile deleteFile = new DeleteFile();
				String filePath = path+"/"+fileNamesave;
				 deleteFile.deleteFile(filePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		@Override
		@Transactional
		public boolean downloadStuAnswer(int assId,
				HttpServletResponse response, String path, String fileName) {
			// TODO Auto-generated method stub
			List<StudentAnswerAnalysis> studentAnswerAnalysisList = new ArrayList<StudentAnswerAnalysis>();
			List<Question> questionList = questionService.queryQuestionsByassId(assId);
			Set<Student> studentList = assignmentService.getAssignment(assId).getText().getCourse().getStudents();
			for(Question question:questionList){
				for(Student student:studentList){
					StudentAnswerAnalysis studentAnswerAnalysis = new StudentAnswerAnalysis();
					studentAnswerAnalysis.setQuestionId(question.getqId());
					studentAnswerAnalysis.setQuestionName(question.getQuestion());
					studentAnswerAnalysis.setQuestionType(question.getQuestionType());
					studentAnswerAnalysis.setSystemAnswer(question.getAnswer());
					studentAnswerAnalysis.setStudentName(student.getStuName());
					studentAnswerAnalysis.setStudentGrade(student.getGrade()+"");
					List<Answer> answers = answerService.queryAnswers(question.getqId(), student.getStuId());
					if(answers!=null&&answers.size()>0){
						studentAnswerAnalysis.setStudentAnswer(answers.get(0).getAnswer());
						studentAnswerAnalysis.settORf(answers.get(0).gettOrF());
					}else{
						studentAnswerAnalysis.setStudentAnswer("null");
						studentAnswerAnalysis.settORf("null");
					}
					studentAnswerAnalysisList.add(studentAnswerAnalysis);
				}
			}
			String fileNamesave = new ExcelBean().setStudentAnswerAnalysis(path, assId+"-"+assignmentService.getAssignment(assId).getAssName(),fileName, studentAnswerAnalysisList);
			UploadDownloadFile uploadFile = new UploadDownloadFile();
			try {
				String re =  uploadFile.download(response,path, fileNamesave);
				System.out.println("下载studentAnswerAnalysis："+re);
				//删除文件
				DeleteFile deleteFile = new DeleteFile();
				String filePath = path+"/"+fileNamesave;
				 deleteFile.deleteFile(filePath);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		@Override
		@Transactional
		public boolean downloadLogStu(String[] courseIds,
				HttpServletResponse response, String path, String fileName) {
			// TODO Auto-generated method stub
			List<Log> listAll = new ArrayList<Log>();
			for(int i = 0;i<courseIds.length;i++){
				List<Log> list=logDAO.queryLogsByCourseIdStu(courseIds[i]);
				for(int j=0;list!=null&&j<list.size();j++){
					listAll.add(list.get(j));
				}
			}
			String fileNamesave = new ExcelBean().setLogs(path, fileName, listAll);
			UploadDownloadFile uploadFile = new UploadDownloadFile();
			try {
				String re =  uploadFile.download(response,path, fileNamesave);
				System.out.println("下载StuLog："+re);
				//删除文件
				DeleteFile deleteFile = new DeleteFile();
				String filePath = path+"/"+fileNamesave;
				 deleteFile.deleteFile(filePath);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		@Override
		@Transactional
		public boolean downloadLogTea(String[] courseIds,
				HttpServletResponse response, String path, String fileName) {
			// TODO Auto-generated method stub
			List<Log> listAll = new ArrayList<Log>();
			for(int i = 0;i<courseIds.length;i++){
				List<Log> list=logDAO.queryLogsByCourseIdTea(courseIds[i]);
				for(int j=0;list!=null&&j<list.size();j++){
					listAll.add(list.get(j));
				}
			}
			String fileNamesave = new ExcelBean().setLogs(path, fileName, listAll);
			UploadDownloadFile uploadFile = new UploadDownloadFile();
			try {
				String re =  uploadFile.download(response,path, fileNamesave);
				System.out.println("下载TeaLog："+re);
				//删除文件
				DeleteFile deleteFile = new DeleteFile();
				String filePath = path+"/"+fileNamesave;
				 deleteFile.deleteFile(filePath);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		@Override
		@Transactional
		public List<Log> queryLogStu(String[] courseIds) {
			// TODO Auto-generated method stub
			List<Log> listAll = new ArrayList<Log>();
			for(int i = 0;i<courseIds.length;i++){
				List<Log> list=logDAO.queryLogsByCourseIdStu(courseIds[i]);
				for(int j=0;list!=null&&j<list.size();j++){
					listAll.add(list.get(j));
				}
			}
			return listAll;
		}

		@Override
		@Transactional
		public List<Log> queryLogTea(String[] courseIds) {
			// TODO Auto-generated method stub
			List<Log> listAll = new ArrayList<Log>();
			for(int i = 0;i<courseIds.length;i++){
				List<Log> list=logDAO.queryLogsByCourseIdTea(courseIds[i]);
				for(int j=0;list!=null&&j<list.size();j++){
					listAll.add(list.get(j));
				}
			}
			return listAll;
		}
		
}
