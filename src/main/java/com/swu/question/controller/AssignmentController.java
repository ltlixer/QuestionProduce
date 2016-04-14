package com.swu.question.controller;

import java.io.IOException;
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
import com.swu.question.entity.Assignment;
import com.swu.question.entity.Course;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.service.AssignmentService;
import com.swu.question.service.CourseService;
import com.swu.question.service.QuestionService;
import com.swu.question.service.ScoreAssignmentService;
import com.swu.question.service.StudentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
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
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("/linkAddAssignment")
	public String linkAddAssignment(ModelMap model, HttpSession session) {
		logger.info("link addAssignment page.");
		System.out.println("link addAssignment page.");

		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courseList = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courseList", courseList);

		List<Assignment> list = assignmentService.listAssignment();
		model.addAttribute("list", list);

		model.addAttribute("assignment", new Assignment());
		return "/learning/addAssignment";
	}

	@RequestMapping("/addAssignment")
	public void addAssignment(ModelMap model,
			HttpSession session, HttpServletRequest request,HttpServletResponse response) throws IOException {
		Teacher teacher = (Teacher) session.getAttribute("tea");
		JSONObject json=JSONObject.fromObject(request.getParameter("data"));
		@SuppressWarnings("unchecked")
		List<Map<String,String>> contents=(List<Map<String, String>>) json.getJSONArray("content");
		@SuppressWarnings("unchecked")
		List<Map<String,String>> ass =(List<Map<String, String>>) json.getJSONArray("ass");
		@SuppressWarnings("unchecked")
		List<Map<String,String>> log =(List<Map<String, String>>) json.getJSONArray("log");
       
		boolean b =assignmentService.addAssignment(contents,teacher,ass,log);
		
		if(b){
			response.getWriter().write("success");
		}else{
			response.getWriter().write("fail");
		}
	}
	
	/*@RequestMapping(value = "/selectTeacher", method = RequestMethod.POST)
	public String selectTeacher(ModelMap model, HttpServletRequest request,
			HttpSession session) {
		logger.info("query Teacher.");
		Student student = (Student) session.getAttribute("stu");
		String[] teaIds = request.getParameterValues("teaIds");
		 studentService.selcetTeacher(teaIds, student);
		return "redirect:/checkTeacher";
	}*/

	@RequestMapping("/queryAssignment/{pageNow}")
	public String queryAssignment(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("tea");
		List<Assignment> list = assignmentService.selectAssignmentByteaId(
				teacher.getTeaId(), pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = assignmentService.countAssignmentByTeaId(teacher
					.getTeaId());
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);
		return "/learning/manageAssignment";
	}

	@RequestMapping("/deleteAssignment/{assId}")
	public String deleteAssignment(ModelMap model,
			@PathVariable("assId") Integer assId) {
		boolean b = scoreAssignmentService.deleteScoreAssignmentByAssId(assId);
		if(b){
			 b = questionService.deleteQuestionByAssId(assId);
		}
		if(b){
			assignmentService.deleteAssignment(assId);
		}
		return "redirect:/assignment/queryAssignment/1";
	}

	//学生端
	@RequestMapping("/stulinkqueryAssignment")
	public String linkqueryAssignmentByCourse(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		Student student = (Student) session.getAttribute("stu");
		 List<Course> courses = studentService.selectStudentToCourses(student.getStuId());
		 if(courses==null||courses.size()==0){
			 model.addAttribute("courseSize","0");
		 }
		 model.addAttribute("pageNow", "0");
		 model.addAttribute("sumCount", "0");
		 model.addAttribute("link","first");
		 model.addAttribute("courses", courses);
		return "/learning/choseAssignment";
	}
	
	//学生端
	@RequestMapping("/queryAssignmentByCourseId")
	public String queryAssignmentByCourse(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		Student student = (Student) session.getAttribute("stu");
		String findAss = request.getParameter("findAss");
		String courseId = request.getParameter("course");
		// 得到未完成的作业
		List<Assignment> assignments = assignmentService.listAllAssignment(
				Integer.parseInt(courseId), student.getStuId(), findAss);
		if(assignments!=null&&assignments.size()>0){
			model.addAttribute("infor", "have");
		}else{
			model.addAttribute("infor", "no");
		}
		model.addAttribute("assignments", assignments);
		model.addAttribute("findAss", findAss);
		//查询课程信息
		List<Course> courses = studentService.selectStudentToCourses(student.getStuId(), Integer.parseInt(courseId));
		 if(courses.size()==0){
			 model.addAttribute("courseSize","0");
		 }
		 model.addAttribute("courses", courses);
		
		return "/learning/choseAssignment";
	}

	@RequestMapping("/doAssignment/{assId}")
	public String doAssignment(ModelMap model,
			@PathVariable("assId") Integer assId) {
		Assignment assignment = assignmentService.getAssignment(assId);
		model.addAttribute("assignment", assignment);
		model.addAttribute("scoreAssignment", new ScoreAssignment());
		return "/learning/doAssignment";
	}


	@RequestMapping("/finishedAssignment/{pageNow}")
	public String finishedAssignment(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpServletRequest request) {
		Student student = (Student) request.getSession().getAttribute("stu");
		List<ScoreAssignment> list = scoreAssignmentService
				.selectFinishedAssignment(student.getStuId(), pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = scoreAssignmentService
					.selectFinishedAssignment(student.getStuId());
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);
		return "/learning/finishedAssignment";
	}

	@RequestMapping("/queryScoreAssignment/{pageNow}")
	public String queryScoreAssignment(@PathVariable("pageNow") int pageNow,ModelMap model, 
			HttpServletRequest request,HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("tea");
		//查找待批改的作业
		List<ScoreAssignment> list = scoreAssignmentService
				.findAssignment(teacher.getTeaId(),pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = scoreAssignmentService.findAssignment(teacher
					.getTeaId());
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);
		return "/learning/correctAssignment";
	}

	// 提交批改后的作业
	@RequestMapping("/submitCorrect")
	public String submitCorrect(ModelMap model, HttpServletRequest request) {
		int saId = Integer.parseInt(request.getParameter("saId"));
		String evaluate = request.getParameter("evaluate");
		int score = Integer.parseInt(request.getParameter("score"));
		scoreAssignmentService.updateScoreAssignment(saId, evaluate, score);

		return "redirect:/assignment/queryScoreAssignment";
	}

	@RequestMapping("/showScoreAssignment/{pageNow}")
	public String showScoreAssignment(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute("tea");
		List<ScoreAssignment> list = scoreAssignmentService.findAssignment(
				teacher.getTeaId(), pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = scoreAssignmentService.findAssignment(teacher
					.getTeaId());
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);
		return "/learning/showScoreAssignment";
	}

	@RequestMapping("/queryScoreAssignmentBystuId/{pageNow}")
	public String queryScoreAssignmentByStuId(
			@PathVariable("pageNow") int pageNow, ModelMap model,
			HttpServletRequest request) {
		Student student = (Student) request.getSession().getAttribute("stu");
		List<ScoreAssignment> list = scoreAssignmentService
				.queryScoreAssignmentByStuId(student.getStuId(), pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = scoreAssignmentService
					.queryScoreAssignmentByStuId(student.getStuId());
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);
		return "/learning/showScoreAssignment";
	}
	
	
	/*@RequestMapping("/submitAssignment")
	public String submitAssignment(ModelMap model,
			@ModelAttribute("scoreAssignment") ScoreAssignment scoreAssignment,
			HttpServletRequest request) {
		int assId = Integer.parseInt(request.getParameter("assId"));
		Student student = (Student) request.getSession().getAttribute("stu");
		Assignment assignment = assignmentService.getAssignment(assId);
		scoreAssignment.setAssignment(assignment);
		scoreAssignment.setStudent(student);
		scoreAssignmentService.addScoreAssignment(scoreAssignment);
		return "redirect:/assignment/queryAssignmentByTeas";
	}*/
	
}
