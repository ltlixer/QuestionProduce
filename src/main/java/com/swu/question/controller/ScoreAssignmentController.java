package com.swu.question.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swu.question.HomeController;
import com.swu.question.entity.Answer;
import com.swu.question.entity.Log;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.service.AnswerService;
import com.swu.question.service.AssignmentService;
import com.swu.question.service.CourseService;
import com.swu.question.service.LogService;
import com.swu.question.service.QuestionService;
import com.swu.question.service.ScoreAssignmentService;
import com.swu.question.service.StudentService;

@Controller
@RequestMapping("/scoreAssignment")
public class ScoreAssignmentController {
	@Autowired
	private ScoreAssignmentService scoreAssignmentService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private LogService logService;
	@Autowired
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	
	/**
	 * 获取作业成绩，优良中及格不及格各有多少人
	 * @param assId
	 * @return json数据
	 */
	@ResponseBody
	@RequestMapping("/queryScoreAssignment/{assId}")
	public List<ScoreAssignment> queryAssignmentByAssId(@PathVariable("assId") int assId) {
		List<ScoreAssignment> scoreAssignmentList = scoreAssignmentService.queryScoreAssignmentByAssId(assId);
		return scoreAssignmentList;
	}
	
	/**
	 * 获取某次作业的  学生姓名、用时
	 * @param assId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryStuTime/{assId}")
	public List<Log> queryStuTimeByAssId(@PathVariable("assId") int assId) {
		List<Log> logList = logService.queryStudentCostTime(assId);
		return logList;
	}
	/**
	 * 获取某次作业每个问题的正确率
	 * @param assId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryStuAnswerCorrectRate/{assId}")
	public List<Answer> queryStuAnswerCorrectRate(@PathVariable("assId") int assId) {
		List<Answer> stuAnswerCorrectRate = answerService.queryStuAnswerCorrectRate(assId);
		return stuAnswerCorrectRate;
	}
	
}
