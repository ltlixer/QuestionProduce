package com.swu.question.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swu.question.HomeController;
import com.swu.question.entity.Course;
import com.swu.question.entity.Teacher;
import com.swu.question.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("/manageCourse")
	public String lookCourse(ModelMap model, HttpSession session) {
		logger.info("manageCourse page.");
		Teacher teacher = (Teacher) session.getAttribute("tea");
		if (teacher != null) {
			List<Course> list = courseService.listCourseByTeaId(teacher
					.getTeaId());
			model.addAttribute("courses", list);
			model.addAttribute("course", new Course());
			return "/learning/manageCourse";
		} else {
			return "/user/teaLogin";
		}

	}

	@RequestMapping("/deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable("courseId") Integer courseId) {
		courseService.deleteCourse(courseId);
		return "redirect:/course/manageCourse";
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("course") Course course,
			BindingResult result, HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("tea");
		System.out.println(course.getYear());
		courseService.addCourse(course, teacher);
		return "redirect:/course/manageCourse";
	}
	
	
	@RequestMapping("/queryCourse")
	public String queryCourse(ModelMap model, HttpSession session) {
		logger.info("queryCourse page.");
			List<Course> list = courseService.listCourse();
			model.addAttribute("courses", list);
			return "/learning/manageCourse";
	}

}
