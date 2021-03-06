package com.swu.question;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired 
 	SessionLocaleResolver resolver;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("/main")
	public String mainPage(Locale locale, Model model, HttpSession session) {
		logger.info("main page");
		Teacher teacher = (Teacher) session.getAttribute("tea");
		Student student = (Student) session.getAttribute("stu");
		if(teacher!=null){
			model.addAttribute("tea", teacher);
			return "/index/teacher/index";
		}else{
			if(student!=null){
				model.addAttribute("stu", student);
				return "/index/student/index";
			}else{
				return "redirect:/login";
			}
		}

	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest re) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "redirect:/html/index.html";

	}

	/**
	 * 用户退出
	 * 
	 * @return
	 */
	@RequestMapping("/exit")
	public String userExit(HttpServletRequest request) {
		logger.info("user Exit.");
		// 清除session
		Enumeration<String> em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		request.getSession().invalidate();
		String path = request.getContextPath();
		// 拼接跳转页面路径
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		return "redirect:" + basePath;
	}

	/**
	 * 拦截器拦截退出系统
	 * 
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

	


	/**
	 * 语言切换
	 */
	@RequestMapping("/language")
	public String language(HttpServletRequest request,
			HttpServletResponse response) {
		String language = request.getParameter("locale");
		if (language == null || language.equals("")) {
			resolver.setLocale(request, response, Locale.CHINA);
		} else {
			if (language.equals("zh_cn")) {
				resolver.setLocale(request, response, Locale.CHINA);
			} else if (language.equals("en")) {
				resolver.setLocale(request, response, Locale.ENGLISH);
			} else {
				resolver.setLocale(request, response, Locale.CHINA);
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping("/languageTea")
	public String languageTea(ModelMap model,HttpServletRequest request,
			HttpServletResponse response) {
		String language = request.getParameter("locale");
		if (language == null || language.equals("")) {
			resolver.setLocale(request, response, Locale.CHINA);
		} else {
			if (language.equals("zh_cn")) {
				resolver.setLocale(request, response, Locale.CHINA);
			} else if (language.equals("en")) {
				resolver.setLocale(request, response, Locale.ENGLISH);
			} else {
				resolver.setLocale(request, response, Locale.CHINA);
			}
		}
		RequestContext requestContext = new RequestContext(request);
        model.addAttribute("language", requestContext.getMessage("language"));
		return "/user/teaMain";
	}
	
	@RequestMapping("/languageStu")
	public String languageStu(ModelMap model,HttpServletRequest request,
			HttpServletResponse response) {
		String language = request.getParameter("locale");
		if (language == null || language.equals("")) {
			resolver.setLocale(request, response, Locale.CHINA);
		} else {
			if (language.equals("zh_cn")) {
				resolver.setLocale(request, response, Locale.CHINA);
			} else if (language.equals("en")) {
				resolver.setLocale(request, response, Locale.ENGLISH);
			} else {
				resolver.setLocale(request, response, Locale.CHINA);
			}
		}
		RequestContext requestContext = new RequestContext(request);
        model.addAttribute("language", requestContext.getMessage("language"));
		return "/user/stuMain";
	}
}
