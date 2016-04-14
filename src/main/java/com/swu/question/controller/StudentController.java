package com.swu.question.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.swu.question.entity.Student;
import com.swu.question.service.CourseService;
import com.swu.question.service.StudentService;
import com.swu.question.service.TeacherService;
import com.swu.question.util.Paging;

import net.sf.json.JSONObject;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TeacherService teacherService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * 加载student Login 页面
	 * 
	 * @return
	 */
	@RequestMapping("/linkStuLogin")
	public String linkStuLogin(ModelMap model) {
		logger.info("link stu_Login page.");
		model.addAttribute("student", new Student());
		return "/user/stuLogin";
	}

	/**
	 * 学生登录
	 * 
	 * @param student
	 * @param model
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/stuLogin", method = RequestMethod.POST)
	public String stuLogin(ModelMap model,
			@Valid @ModelAttribute("student") Student student,
			BindingResult result, HttpSession session) {
		logger.info("Student Login.");
		// 如果有验证错误 返回到form页面
		if (result.hasErrors()) {
			return "/user/stuLogin";
		}
		Student stu = studentService.studentLogin(student.getStuNum(),
				student.getStuPassword());
		System.out.println(student.getStuNum());
		if (stu != null) {
			session.setAttribute("stu", stu);
			return "/user/stuMain";
		} else {
			model.addAttribute("student", new Student());
			model.addAttribute("stuLoginInfor", "用户名或密码错误!");
			return "/user/stuLogin";
		}

	}

	/**
	 * 加载学生注册界面
	 * 
	 * @return
	 */
	@RequestMapping("/linkStuRegister")
	public String linkStuRegister(ModelMap model) {
		logger.info("link linkStuRegister page.");
		model.addAttribute("student", new Student());
		return "/user/stuRegister";
	}

	/**
	 * 学生注册提交
	 * 
	 * @param student
	 * @param model
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/stuRegister", method = RequestMethod.POST)
	public String stuRegister(ModelMap model,
			@Valid @ModelAttribute("student") Student student,
			BindingResult result) {
		logger.info("Student Login.");
		if (result.hasErrors()) {
			return "/user/stuRegister";
		}

		boolean re = studentService.addStudent(student);
		if (re) {
			model.addAttribute("student", new Student());
			return "/user/stuLogin";
		} else {
			return "/user/stuRegister";
		}
	}

	/**
	 * 用户注册 Ajax 验证 账号合法性
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/registerAjax")
	public void editPass(HttpServletRequest request,
			HttpServletResponse response) {
		String stuNum = request.getParameter("stuNum");
		boolean f = studentService.studentRegisterCheck(stuNum);
		String str = "0";
		if (f) {
			str = "1";
		}
		response.setContentType("text/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(str);// 用于返回对象参数
		} catch (IOException e) {
			e.printStackTrace();
		}// 一定要response.setCharacterEncoding("UTF-8");后面，不然返回乱码
	}

	
	
	/**
	 * 链接到修改密码界面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/linkStuUpdatePassword")
	public String linkStuUpdatePassword(ModelMap model, HttpSession session) {
		logger.info("link tea_Login page.");
		Student student = (Student) session.getAttribute("stu");
		model.addAttribute("name", student.getStuName());
		model.addAttribute("ps", student.getStuPassword());
		model.addAttribute("id", student.getStuId());
		return "/user/stuChangePasswd";
	}

	/**
	 * 修改密码
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateStuPassword", method = RequestMethod.POST)
	public String updateTeaPassword(ModelMap model, HttpServletRequest request) {
		logger.info("link tea_Login page.");
		int stuId = Integer.parseInt(request.getParameter("id"));
		String passwd = request.getParameter("newPassword");
		if (studentService.studentUpdatePssword(stuId, passwd)) {
			return "redirect:/linkStuLogin";
		} else {
			return "/user/stuChangePasswd";
		}
	}

	/**
	 * 链接到邮箱修改页面
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/linkUpdateStudent")
	public String linkUpdateStudent(ModelMap model, HttpSession session) {
		System.out.println("linkUpdateTeacher");
		Student sessionStudent = (Student) session.getAttribute("stu");
		model.addAttribute("student", sessionStudent);
		return "/user/updateStudent";
	}
	/**
	 * 修改邮箱
	 * @param student
	 * @param model
	 * @param result
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateTeacher(@ModelAttribute("student") Student student,
			ModelMap model, BindingResult result, HttpSession session) {
		logger.info("Teacher Login.");
		boolean t = studentService.updateStudentInfor(student);
		if (t == true) {
			Student sessionStudent = (Student) session.getAttribute("stu");
			Student student1 = studentService.selectStudent(sessionStudent
					.getStuId());
			session.setAttribute("stu", student1);
			model.addAttribute("infor", "修改成功");
		} else {
			model.addAttribute("infor", "修改失败");
		}
		return "/user/updateStudent";
	}
	
	
	
	
	/*
	*//**
	 * 显示注册过的教师 sam
	 * 
	 * @param teacher
	 * @param model
	 * @param result
	 * @return 返回所有注册过的教师
	 *//*
	@RequestMapping(value = "/queryTeacher/{pageNow}", method = RequestMethod.GET)
	public String queryTeacher(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpServletRequest request) {
		logger.info("query Teacher.");
		List<Teacher> list = teacherService.listTeacher(pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = teacherService.listTeacher1();
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);

		return "/learning/addTeacher";

	}*/
	/**
	 * 查询已选择的老师
	 * @param model
	 * @param session
	 * @return
	 */
	/*@RequestMapping(value = "/checkTeacher")
	public String checkTeacher(ModelMap model, HttpSession session) {
		Student student = (Student) session.getAttribute("stu");
		Set<Teacher> teacher = studentService.selectStudentToTeachers(student
				.getStuId());
		model.addAttribute("teacher", teacher);
		return "/learning/checkTeacher";
	}*/

	/**
	 * 将学生选择的教师与学生进行关联
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 */
	/*@RequestMapping(value = "/selectTeacher", method = RequestMethod.POST)
	public String selectTeacher(ModelMap model, HttpServletRequest request,
			HttpSession session) {
		logger.info("query Teacher.");
		Student student = (Student) session.getAttribute("stu");
		String[] teaIds = request.getParameterValues("teaIds");
		studentService.selcetTeacher(teaIds, student);
		return "redirect:/checkTeacher";
	}*/
	
	
	/**
	 * 显示课程
	 * 
	 * @param teacher
	 * @param model
	 * @param result
	 * @return 返回所有课程
	 */
	@RequestMapping(value = "/queryCourse/{pageNow}", method = RequestMethod.GET)
	public String queryCourse(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpServletRequest request) {
		logger.info("query course.");
		List<Course> list = courseService.listCourse(pageNow);
		String resumPage = request.getParameter("sumPage");
		if (pageNow == 1) {
			int sumCount = courseService.countListCourse();
			
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("list", list);
		return "/learning/addCourseForStu";

	}
	/**
	 * 查询已选择的课程
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/checkedCourse")
	public String checkCourse(ModelMap model, HttpSession session) {
		Student student = (Student) session.getAttribute("stu");
		List<Course> course = studentService.selectStudentToCourses(student.getStuId());
		model.addAttribute("course", course);
		return "/learning/checkedCourse";
	}

	//add 学生退选课程
	/**
	 * 
	 * @param courseId
	 * @param session
	 * @return
	 */
		@RequestMapping("/deleteCourseBystu/{courseId}")
		public String deleteCourseBystu(@PathVariable("courseId") Integer courseId
				, HttpSession session) {
			Student student = (Student) session.getAttribute("stu");
			studentService.deleteCourseByStu(courseId, student.getStuId());
			return "redirect:/checkedCourse";
		}
	
	/**
	 * 将学生选择的课程与学生进行关联
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/selectCourse", method = RequestMethod.POST)
	public String selectCourse(ModelMap model, HttpServletRequest request,
			HttpSession session) {
		logger.info("query Course.");
		Student student = (Student) session.getAttribute("stu");
		String[] courseIds = request.getParameterValues("courseIds");
		studentService.selcetCourse(courseIds, student);
		return "redirect:/checkedCourse";
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/test1Sel",method = RequestMethod.POST)
    public void userSel(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
	 	System.out.println("query");
	 	
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        List<Student> testList = studentService.listStudent();
        
        int paging[] = new int[2];
       
        paging = Paging.paging(rows, page, testList.size());
        List<JSONObject> list = new ArrayList<JSONObject>();
        int i = paging[0];
        for (; i < paging[1]; i++)
        {
        	
            Student test1 = testList.get(i);
           // System.out.println(test1);
            Map map = new HashMap();
            map.put("id", test1.getStuId());
            map.put("num", test1.getStuNum());
            map.put("pass", test1.getStuPassword());
            map.put("name", test1.getStuName());
            map.put("email", test1.getStuEmail());
            JSONObject jsonobj = JSONObject.fromObject(map);
            System.out.println(jsonobj.toString());
            list.add(jsonobj);
        }
        Map oo = new HashMap();
        oo.put("rows", list);
        oo.put("total", testList.size());
        //封装页面返回json
        JSONObject jsonobj = JSONObject.fromObject(oo);
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter out = response.getWriter();
            System.out.println(jsonobj.toString()+"json");
            out.print(jsonobj.toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
