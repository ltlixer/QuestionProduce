package com.swu.question;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest re) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
		
	}
	/**
	 * 用户退出
	 * 
	 * @return
	 */
	@RequestMapping("/exit")
	public String userExit() {
		logger.info("user Exit.");
		return "/com/exit";
	}
	/**
	 * 拦截器拦截退出系统
	 * @return
	 */
	@RequestMapping("/filter")
	public String filter() {
		logger.info("user Exit.");
		return "/com/filter";
	}
	@RequestMapping("/userHelp")
	public String userHelp() {
		logger.info("user Help.");
		return "redirect:/resources/help/user_help.html";
	}
	@RequestMapping("/teacherHelp")
	public String teacherHelp() {
		logger.info("teacherr Help.");
		return "redirect:/resources/help/teacher_help.html";
	}
	@RequestMapping("/studentHelp")
	public String studentHelp() {
		logger.info("student Help.");
		return "redirect:/resources/help/student_help.html";
	}
	
	@RequestMapping("/easyUI")
	public String easyUI() {
		logger.info("student Help.");
		return "/user/easyUI";
	}
	
	
}



