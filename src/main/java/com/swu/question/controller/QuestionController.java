package com.swu.question.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swu.question.HomeController;
import com.swu.question.entity.Assignment;
import com.swu.question.entity.Question;
import com.swu.question.service.AssignmentService;
import com.swu.question.service.MultipleChoiceQuestionService;
import com.swu.question.service.QuestionService;
import com.swu.question.service.TextService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TextService textService;
	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	private MultipleChoiceQuestionService multipleChoiceQuestionService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * 教师链接到 作业 问题页面
	 * 
	 * @param model
	 * @param assId
	 * @return
	 */
	@RequestMapping("/tealinkQuestionPage/{assId}")
	public String tealinkQuestionPage(ModelMap model,
			@PathVariable("assId") Integer assId) {
		logger.info("linkQuestionPage.");
		List<Question> listQuestions = questionService
				.queryQuestionsByassId(assId);
		Assignment assignment = assignmentService.getAssignment(assId);
		List<String> listTexts = textService.readWordText(assignment.getText()
				.getTextId());
		model.addAttribute("assId", assId);
		model.addAttribute("textTitle", assignment.getText().getTextTitle());
		model.addAttribute("courseName", assignment.getText().getCourse()
				.getCourseName());
		model.addAttribute("assTime", assignment.getAssTime());
		model.addAttribute("questions", listQuestions);
		model.addAttribute("texts", listTexts);
		model.addAttribute("user", "tea");
		return "/question/questionPageTea";
	}

	/**
	 * 学生链接到 作业 问题页面
	 * 
	 * @param model
	 * @param assId
	 * @return
	 */
	@RequestMapping("/stulinkQuestionPage/{assId}")
	public String stulinkQuestionPage(ModelMap model,
			@PathVariable("assId") Integer assId) {
		logger.info("linkQuestionPage.");
		List<Question> listQuestions = questionService
				.queryQuestionsByassId(assId);
		List<Question> listMultiplechoiceQuestions = new ArrayList<Question>();// 事实类问题
		List<Question> listFactoidQuestions = new ArrayList<Question>();// 事实类问题
		List<Question> listDeeperQuestions = new ArrayList<Question>();// 深层次问题
		List<Question> listOriginalQuestions = new ArrayList<Question>();//原始问题
		for (int i = 0; i < listQuestions.size(); i++) {
			if (listQuestions.get(i).getQuestionType().equals("multiplechoice")) {
				listMultiplechoiceQuestions.add(listQuestions.get(i));
				
			}
			if (listQuestions.get(i).getQuestionType().equals("factoid")) {
				listFactoidQuestions.add(listQuestions.get(i));
			}
			if (listQuestions.get(i).getQuestionType().equals("deeper")) {
				listDeeperQuestions.add(listQuestions.get(i));
			}
			if (listQuestions.get(i).getQuestionType().equals("original")) {
				listOriginalQuestions.add(listQuestions.get(i));
			}
		}

		model.addAttribute("MultiplechoiceQuestions", listMultiplechoiceQuestions);
		model.addAttribute("MultiplechoiceSize", listMultiplechoiceQuestions.size());
		model.addAttribute("FactoidQuestions", listFactoidQuestions);
		model.addAttribute("FactoidSize", listFactoidQuestions.size());
		model.addAttribute("DeeperQuestions",listDeeperQuestions);
		model.addAttribute("DeeperSize", listDeeperQuestions.size());
		model.addAttribute("OriginalQuestions", listOriginalQuestions);
		model.addAttribute("OriginalSize", listOriginalQuestions.size());
		
		Assignment assignment = assignmentService.getAssignment(assId);
		List<String> listTexts = textService.readWordText(assignment.getText()
				.getTextId());
		model.addAttribute("assId", assId);
		model.addAttribute("textTitle", assignment.getText().getTextTitle());
		model.addAttribute("courseName", assignment.getText().getCourse()
				.getCourseName());
		model.addAttribute("assTime", assignment.getAssTime());
		
		model.addAttribute("questionsize",listQuestions.size());
		model.addAttribute("texts", listTexts);
		model.addAttribute("user", "stu");
		return "/question/questionPageStu";
	}
	
	/**
	 * 根据文章id生成选择题
	 */
	@ResponseBody // 用于返回JSON数据
	@RequestMapping("/getMultipleChoiceQuestion/{textId}")
	public List<Question> getMultipleChoiceQuestion(ModelMap model, @PathVariable("textId") Integer textId,HttpServletRequest request) {
		logger.info("linkQuestionPage.");
		//根据文章id获取选择题列表
		String path = request.getSession().getServletContext()
				.getRealPath("/resources/word-lib/");
		List<Question> questionList = multipleChoiceQuestionService.createMultipleChoiceQuestion(textId,path);
		return questionList;
	}
}
