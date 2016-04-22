package com.swu.question.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swu.question.HomeController;
import com.swu.question.entity.Answer;
import com.swu.question.entity.Assignment;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.service.AnswerService;
import com.swu.question.service.AssignmentService;
import com.swu.question.service.ScoreAssignmentService;
import com.swu.question.service.TextService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private ScoreAssignmentService scoreAssignmentService;
	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	private TextService textService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@RequestMapping("/submitAnswer")
	public String submitAnswer(ModelMap model,HttpServletRequest request,HttpSession session){
		logger.info("linkQuestionPage.");
		Student student = (Student)session.getAttribute("stu");
		String[] answers = request.getParameterValues("answers");
		String[] answerolds = request.getParameterValues("answerold");
		String[] qids = request.getParameterValues("qids");
		String assId = request.getParameter("assId");
		String useTime = request.getParameter("useTime");
		String factoidStartTime  = request.getParameter("factoidStartTime");
		String factoidEndTime = request.getParameter("factoidEndTime");
		String deeperStartTime = request.getParameter("deeperStartTime");
		String deeperEndTime  = request.getParameter("deeperEndTime");
		String originalStartTime  = request.getParameter("originalStartTime");
		String originalEndTime  = request.getParameter("originalEndTime");
		List<String> list = new ArrayList<String>();
		list.add(factoidStartTime);
		list.add(factoidEndTime);
		list.add(deeperStartTime);
		list.add(deeperEndTime);
		list.add(originalStartTime);
		list.add(originalEndTime);
		answerService.addAnswers(answers,answerolds,qids,assId,student,useTime,list);
		return "redirect:/assignment/stulinkqueryAssignment";
	}
	
	@RequestMapping("/tealinkAnswerPage/{saId}")
	public String tealinkAnswerPage(ModelMap model,
			@PathVariable("saId") Integer saId){
		logger.info("tealinkAnswerPage.");
		List<Answer> listanswers = answerService.queryAnswerByscoreAssId(saId);
		ScoreAssignment scoreAssignment = scoreAssignmentService.findscoreAssignment(saId);
		Assignment assignment =assignmentService.getAssignment(scoreAssignment.getAssignment().getAssId());
		List<String> listTexts = textService.readWordText(assignment.getText().getTextId());
		
		model.addAttribute("evaluate",scoreAssignment.getEvaluate());
		model.addAttribute("useTime", scoreAssignment.getUseTime());
		model.addAttribute("stuName", scoreAssignment.getStudent().getStuName());
		model.addAttribute("textTitle", assignment.getText().getTextTitle());
		model.addAttribute("courseName", assignment.getText().getCourse().getCourseName());
		/*model.addAttribute("assTime", assignment.getAssTime());*/
		model.addAttribute("saId", saId);
		model.addAttribute("answers", listanswers);
		model.addAttribute("texts", listTexts);
		model.addAttribute("user", "tea");
		return "/question/answerPage";
	}
	@RequestMapping("/submitScore")
	public void submitScore(ModelMap model,HttpServletRequest request,HttpServletResponse response){
		logger.info("submitScore.");
		try {
		JSONObject json=JSONObject.fromObject(request.getParameter("data"));
		//scores 存放 answerId  tOrT
		@SuppressWarnings("unchecked")
		List<Map<String,String>> scores=(List<Map<String, String>>) json.getJSONArray("scores");
		//sa存放  scoreAss的Id  tOrF evaluate score
		@SuppressWarnings("unchecked")
		List<Map<String,String>> sa =(List<Map<String, String>>) json.getJSONArray("sa");
		String str= answerService.updateScoreAndAnswer(scores, sa);
		if(str.equals("success")){
			response.getWriter().write("success");
		}else{
			response.getWriter().write("fail");		
		}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@RequestMapping("/showAnswer/{saId}")
	public String linkShowAnswer(ModelMap model,
			@PathVariable("saId") Integer saId,HttpSession session){
		logger.info("tealinkAnswerPage.");
		List<Answer> listanswers = answerService.queryAnswerByscoreAssId(saId);
		ScoreAssignment scoreAssignment = scoreAssignmentService.findscoreAssignment(saId);
		Assignment assignment =assignmentService.getAssignment(scoreAssignment.getAssignment().getAssId());
		List<String> listTexts = textService.readWordText(assignment.getText().getTextId());
		double score = scoreAssignment.getScore();
		model.addAttribute("score",score);
		model.addAttribute("evaluate",scoreAssignment.getEvaluate());
		model.addAttribute("useTime", scoreAssignment.getUseTime());
		model.addAttribute("stuName", scoreAssignment.getStudent().getStuName());
		model.addAttribute("textTitle", assignment.getText().getTextTitle());
		model.addAttribute("courseName", assignment.getText().getCourse().getCourseName());
		/*model.addAttribute("assTime", assignment.getAssTime());*/
		model.addAttribute("saId", saId);
		model.addAttribute("answers", listanswers);
		model.addAttribute("texts", listTexts);
		Teacher tea =(Teacher) session.getAttribute("tea");
		Student stu = (Student) session.getAttribute("stu");
		if(tea!=null){
			model.addAttribute("user", "tea");
		}else if(stu!=null){
			model.addAttribute("user", "stu");
		}
		return "/question/showAnswer";
	}
	
}
