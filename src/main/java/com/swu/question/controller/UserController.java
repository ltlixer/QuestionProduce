package com.swu.question.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.swu.question.HomeController;
import com.swu.question.entity.Course;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.service.CourseService;
import com.swu.question.service.StudentService;
import com.swu.question.service.TeacherService;
import com.swu.question.util.Paging;

import net.sf.json.JSONObject;

@Controller
public class UserController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	/**
	 * 加载Login登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String linkTeaLogin(ModelMap model,HttpSession session,HttpServletRequest request) {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		RequestContext requestContext = new RequestContext(request);
		model.addAttribute("language", requestContext.getMessage("language"));
		if(role!=null){
			if(userName!=null&&password!=null){
				if("teacher".equals(role)){
					Teacher tea = teacherService.teacherLogin(userName,password);
					if (tea != null) {
						session.setAttribute("tea", tea);
						logger.info(tea.getTeaName()+" Login.");
						return "/user/teaMain";
					}
				}else if("student".equals(role)){
					Student stu = studentService.studentLogin(userName,password);
					if (stu != null) {
						session.setAttribute("stu", stu);
						logger.info(stu.getStuName()+" Login.");
						return "/user/stuMain";
					}
				}
			}
		}
		return "redirect:/html/login.html";
	}
	
}
