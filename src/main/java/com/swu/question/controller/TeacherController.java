package com.swu.question.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.swu.question.HomeController;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.service.StudentService;
import com.swu.question.service.TeacherService;
import com.swu.question.util.Paging;

import net.sf.json.JSONObject;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * 加载teacher Login 页面
	 * 
	 * @return
	 */
	@RequestMapping("/linkTeaLogin")
	public ModelAndView linkTeaLogin() {
		logger.info("link tea_Login page.");
		return new ModelAndView("/user/teaLogin", "teacher", new Teacher());
	}

	/**
	 * 教师登录
	 * 
	 * @param Teacher
	 * @param model
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/teaLogin", method = RequestMethod.POST)
	public String teaLogin(@ModelAttribute("teacher") Teacher teacher,
			ModelMap model, BindingResult result, HttpSession session) {
		logger.info("Teacher Login.");
		if (result.hasErrors()) {
			return "/user/teaLogin";
		}
		Teacher tea = teacherService.teacherLogin(teacher.getTeaNum(),
				teacher.getTeaPassword());
		System.out.println(teacher.getTeaNum());
		if (tea != null) {
			session.setAttribute("tea", tea);
			return "/user/teaMain";
		} else {
			model.addAttribute("teacher", new Teacher());
			model.addAttribute("teaLoginInfor", "用户名或密码错误!");
			return "/user/teaLogin";
		}
	}

	/**
	 * 加载教师注册界面
	 * 
	 * @return
	 */
	@RequestMapping("/linkTeaRegister")
	public ModelAndView linkTeaRegister() {
		logger.info("link linkTeaRegister page.");
		return new ModelAndView("/user/teaRegister", "teacher", new Teacher());
	}

	/**
	 * 用户注册 Ajax 验证 账号合法性
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/teaRegisterAjax")
	public void editPass(HttpServletRequest request,
			HttpServletResponse response) {
		String teaNum = request.getParameter("teaNum");
		boolean f = teacherService.teacherRegisterCheck(teaNum);
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
	 * 教师注册提交
	 * 
	 * @param Teacher
	 * @param model
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/teaRegister", method = RequestMethod.POST)
	public ModelAndView teaRegister(@ModelAttribute("teacher") Teacher teacher,
			ModelMap model, BindingResult result) {
		logger.info("Teacher Login.");
		boolean t = teacherService.addTeacher(teacher);
		if (t == true) {
			return new ModelAndView("/user/teaLogin", "teacher", new Teacher());
		} else {
			return new ModelAndView("/user/teaRegister", "","");
		}
	}

	/**
	 * 链接到修改密码界面
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/linkTeaUpdatePassword")
	public String linkTeaUpdatePassword(ModelMap model, HttpSession session) {
		logger.info("link tea_Login page.");
		Teacher teacher = (Teacher) session.getAttribute("tea");
		model.addAttribute("name", teacher.getTeaName());
		model.addAttribute("ps", teacher.getTeaPassword());
		model.addAttribute("id", teacher.getTeaId());
		return "/user/teaChangePasswd";
	}

	/**
	 * 修改密码
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateTeaPassword", method = RequestMethod.POST)
	public String updateTeaPassword(ModelMap model, HttpServletRequest request) {
		logger.info("link tea_Login page.");
		int teaId = Integer.parseInt(request.getParameter("id"));
		String passwd = request.getParameter("newPassword");
		if (teacherService.teacherUpdatePssword(teaId, passwd)) {
			return "redirect:/linkTeaLogin";
		} else {
			return "/user/teaChangePasswd";
		}
	}

	@RequestMapping("/linkUpdateTeacher")
	public String linkUpdateTeacher(ModelMap model, HttpSession session) {
		System.out.println("linkUpdateTeacher");
		Teacher sessionTeacher = (Teacher) session.getAttribute("tea");
		// Teacher teacher =
		// teacherService.queryTeacher(sessionTeacher.getTeaId());
		// session.setAttribute("tea", teacher);
		model.addAttribute("teacher", sessionTeacher);
		return "/user/updateTeacher";
	}

	@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
	public String updateTeacher(@ModelAttribute("teacher") Teacher teacher,
			ModelMap model, BindingResult result, HttpSession session) {
		logger.info("Teacher Login.");
		boolean t = teacherService.updateTeacherInfor(teacher);
		if (t == true) {
			Teacher sessionTeacher = (Teacher) session.getAttribute("tea");
			Teacher teacher1 = teacherService.queryTeacher(sessionTeacher
					.getTeaId());
			session.setAttribute("tea", teacher1);
			model.addAttribute("infor", "修改成功");
		} else {
			model.addAttribute("infor", "修改失败");
		}
		return "/user/updateTeacher";
	}

	@RequestMapping("/queryStudentByteaId")
	public String queryStudentByteaId(ModelMap model, HttpSession session) {
		
		return "/learning/managerStudent";
	}
	
	@RequestMapping("/ajaxStudentByteaId")
	public void ajaxStudentByteaId(ModelMap model, HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getParameter("rows"));
		int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
		Teacher sessionTeacher = (Teacher) session.getAttribute("tea");
		/*Set<Student> students = teacherService
				.queryTeacherToStudent(sessionTeacher.getTeaId());
		
		List<Student> stulist = new ArrayList<Student>();
		Iterator<Student> stu = students.iterator();// 先迭代出来
		while (stu.hasNext()) {// 遍历
			Student student = (Student) stu.next();
			stulist.add(student);
		}
		*/
		List<Student> stulist = studentService.listStudent();
		Collections.sort(stulist, new Comparator<Student>(){  
	            public int compare(Student o1, Student o2) {  
	                if(o1.getStuNum().compareTo(o2.getStuNum())>0){  
	                    return 1;  
	                }  
	                return -1;  
	            }  
	        });   
		
		int paging[] = new int[2];
	       
        paging = Paging.paging(rows, page, stulist.size());
        List<JSONObject> list = new ArrayList<JSONObject>();
        int i = paging[0];
        for (; i < paging[1]; i++)
        {
        	
            Student student = stulist.get(i);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("stuId", student.getStuId());
            map.put("num", student.getStuNum());
            map.put("name", student.getStuName());
            map.put("email", student.getStuEmail());
            map.put("grade", student.getGrade());
            JSONObject jsonobj = JSONObject.fromObject(map);
            list.add(jsonobj);
        }
        Map<String,Object> oo = new HashMap<String,Object>();
        oo.put("rows", list);
        oo.put("total", stulist.size());
        //封装页面返回json
        JSONObject jsonobj = JSONObject.fromObject(oo);
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter out = response.getWriter();
            out.print(jsonobj.toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
	}

	
	
	@RequestMapping(value = "/addStudentByExcell", method = RequestMethod.POST)
	public String addStudentByExcell(ModelMap model,HttpServletRequest request, HttpSession session,@RequestParam MultipartFile file) {
		
		Teacher teacher = (Teacher) request.getSession().getAttribute("tea");
		String teaNum = teacher.getTeaNum();
		String savePath = request.getSession().getServletContext()
				.getRealPath("/resources/uploadStudent/" + teaNum);
			String str = teacherService.addStudents(file, savePath, teacher);
			model.addAttribute("infor", str);
		return "/learning/managerStudent";
	}
	
	@RequestMapping("/removeStudentBystuId/{stuId}")
	public String removeStudentBystuId(@PathVariable("stuId") Integer stuId,
			ModelMap model, HttpSession session) {
		Teacher sessionTeacher = (Teacher) session.getAttribute("tea");
		int teaId = sessionTeacher.getTeaId();
		teacherService.removeStudentBystuId(teaId, stuId);
		return "/learning/managerStudent";
	}

	@RequestMapping("/removeStudentBystuIds")
	public String removeStudentBystuIds(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		Teacher sessionTeacher = (Teacher) session.getAttribute("tea");
		int teaId = sessionTeacher.getTeaId();
		String stuIdsStrs = request.getParameter("stuIds");
		String[] stuIdsStr = stuIdsStrs.split("-");
		if (stuIdsStr != null && stuIdsStr.length > 0) {
			for (int i = 0; i < stuIdsStr.length; i++) {
				int stuId = Integer.parseInt(stuIdsStr[i]);
				teacherService.removeStudentBystuId(teaId, stuId);
			}
		}
		return "/learning/managerStudent";
	}

}
