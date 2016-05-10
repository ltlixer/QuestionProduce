package com.swu.question.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.swu.question.HomeController;
import com.swu.question.entity.Course;
import com.swu.question.entity.QuestionType;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.entity.Text;
import com.swu.question.service.CourseService;
import com.swu.question.service.QuestionService;
import com.swu.question.service.StudentService;
import com.swu.question.service.TextService;

/**
 * Text controller 负责处理有关 Text的请求
 * 
 * @author 严浩
 *
 */
@Controller
@RequestMapping("/text")
public class TextController {
	@Autowired
	private TextService textService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private QuestionService questionService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@ResponseBody
	@RequestMapping("/queryTextByCourseId/{courseId}")
	public List<Text> queryTextByCourseId(@PathVariable("courseId") int courseId) {
		logger.info("queryTextByCourseId page.");
		List<Text> textList = textService.queryTextByCourseId(courseId);
		return textList;
	}
	// 教师端
	@RequestMapping("/linkAddText")
	public ModelAndView linkAddText(ModelMap model, HttpSession session) {
		logger.info("link linkAddText page.");
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> listCourse = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("listCourse", listCourse);
		model.addAttribute("teaName", teacher.getTeaName());
		return new ModelAndView("/learning/addText", "text", new Text());
	}
	// 教师端
	@RequestMapping("/queryText/{pageNow}")
	public String queryText(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		//课文已发布作业 ，删除课文 返回值，提示不能删除该课文

		String infor ="";
		if(pageNow==-1){
			pageNow =1;
			infor ="该课文你已发布了作业，不能删除。若要删除，请先先删除该课文对应的作业！";
		}
		if(pageNow==-2){
			pageNow =1;
			infor ="该课文你已有评估数据，不能删除！";
		}
		String resumPage = request.getParameter("sumPage");
		Teacher teacher = (Teacher) request.getSession().getAttribute("tea");
		List<Text> texts = textService.queryTextByTeas(teacher.getTeaId(), pageNow);
		List<QuestionType> questionTypes = questionService.queryQuestionTypes();
		if(questionTypes.isEmpty()){
			
		}
		model.addAttribute("questionTypes", questionTypes);
		model.addAttribute("texts", texts);
		if (pageNow == 1) {
			int sumCount = textService.countqueryTextByTeas(teacher.getTeaId());
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("user", "tea");
		if(!infor.equals("")){
			model.addAttribute("infor", infor);
		}
		List<Course> courseList = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courseList);
		return "/learning/listText";
	}
	@RequestMapping("/queryTextssByCourseId/{courseId}")
	public String queryTextssByCourseId(@PathVariable("courseId") int courseId,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");

		Teacher teacher = (Teacher) request.getSession().getAttribute("tea");
		List<Text> texts = textService.queryTextByCourseId(courseId);
		List<QuestionType> questionTypes = questionService.queryQuestionTypes();
		if(questionTypes.isEmpty()){
			
		}
		model.addAttribute("questionTypes", questionTypes);
		model.addAttribute("texts", texts);
		
		List<Course> courseList = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courseList);
		return "/learning/listText";
	}
	
	//学生端
	@RequestMapping("/stuLinklistText")
	public ModelAndView stuLinklistText(
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		Student student = (Student) session.getAttribute("stu");
		List<Course> courses = studentService.selectStudentToCourses(student.getStuId());
		 if(courses==null||courses.size()==0){
			 model.addAttribute("courseSize","0");
		 }
		 model.addAttribute("pageNow", "0");
		 model.addAttribute("sumCount", "0");
		 model.addAttribute("link","first");
		 model.addAttribute("user", "stu");
		 
		return new ModelAndView("/learning/listText", "courses", courses);
	}

	//学生端
	@RequestMapping("/queryTextByCourse/{pageNow}")
	public ModelAndView queryTextByTeas(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		String resumPage = request.getParameter("sumPage");
		Student student = (Student) session.getAttribute("stu");
		String findText = request.getParameter("findText");
		String courseId = request.getParameter("course");
		System.out.println(courseId);
		List<Text> texts = textService.queryTextByCourseId(courseId, pageNow, findText);
		if(texts!=null&&texts.size()>0){
			model.addAttribute("infor", "have");
		}else{
			model.addAttribute("infor", "no");
		}
		if (pageNow == 1) {
			int sumCount = textService.countTextByCourseId(courseId, findText);
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		//课程信息查询
		List<Course> courses = studentService.selectStudentToCourses(student.getStuId(), Integer.parseInt(courseId));
		 if(courses.size()==0){
			 model.addAttribute("courseSize","0");
		 }
		 model.addAttribute("courses", courses);
		model.addAttribute("findText", findText);
		model.addAttribute("pageNow", pageNow);
		model.addAttribute("user", "stu");
		return new ModelAndView("/learning/listText", "texts", texts);
	}

	/*@RequestMapping("/downloadTextList/{pageNow}")
	public ModelAndView downloadText(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		String resumPage = request.getParameter("sumPage");
		Student student = (Student) session.getAttribute("stu");
		List<Teacher> teachers = studentService
				.listTeachers(student.getStuId());
		List<Text> texts = textService.queryTextByTeas(teachers, pageNow, null);
		if (pageNow == 1) {
			int sumCount = textService.countTextByTeas(teachers, null);
			model.addAttribute("sumCount", sumCount);
		} else {
			model.addAttribute("sumCount", resumPage);
		}
		model.addAttribute("pageNow", pageNow);
		return new ModelAndView("/learning/downloadText", "texts", texts);
	}*/

	@RequestMapping("/lookText/{teaNum}")
	public String lookText(@PathVariable("teaNum") String teaNum,
			ModelMap model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String textName = request.getParameter("textName");
		textName = textName.substring(0, textName.indexOf("_"));
		return "redirect:/resources/uploadText/" + teaNum + "/" + textName
				+ ".html";
	}

	@RequestMapping(value = "/uploadText", method = RequestMethod.POST)
	public String uploadText(@ModelAttribute("text") Text text, ModelMap model,
			HttpServletRequest request, @RequestParam MultipartFile[] files) {
		logger.info("link uploadText.");
		Teacher teacher = (Teacher) request.getSession().getAttribute("tea");
		String teaNum = teacher.getTeaNum();
		String savePath = request.getSession().getServletContext()
				.getRealPath("/resources/uploadText/" + teaNum);
		String courseId = request.getParameter("courseId");
		System.out.println(savePath);
		String information = textService
				.addText(files, savePath, text, teacher,courseId);
		System.out.println(information);
		
		if (information.equals("Success")) {
			List<Text> texts = textService.queryTextByTeas(teacher.getTeaId(), 1);
			model.addAttribute("texts", texts);
			int sumCount = textService.countqueryTextByTeas(teacher.getTeaId());
			model.addAttribute("sumCount", sumCount);
			model.addAttribute("pageNow", 1);
			model.addAttribute("user", "tea");
			return "redirect:/text/queryText/1";
		} else {
			// Teacher teacher = (Teacher) session.getAttribute("tea");
			List<Course> listCourse = courseService.listCourseByTeaId(teacher
					.getTeaId());
			model.addAttribute("listCourse", listCourse);
			model.addAttribute("teaName", teacher.getTeaName());
			model.addAttribute("text", new Text());
			model.addAttribute("infor", information);
			return "/learning/addText";
		}
	}

	@RequestMapping("/downloadText/{teaNum}")
	public String downloadText(@PathVariable("teaNum") String teaNum,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String fileName = request.getParameter("fileName");
		String path = request.getSession().getServletContext()
				.getRealPath("/resources/uploadText/" + teaNum);
		String result = textService.downloadText(response, path, fileName);
		model.addAttribute("downloadInfor", result);
		return null;
	}

	@RequestMapping("/deleteText/{textId}")
	public String deleteText(@PathVariable("textId") Integer textId,
			ModelMap model, HttpSession session) {
		logger.info("link linkAddText page.");
		System.out.println(textId);
		String str = textService.deleteText(textId);
		if(str.equals("no")){//有发布的作业，不能删除
			return "redirect:/text/queryText/-1";
		}
		if(str.equals("no2")){//有发布的作业，不能删除
			return "redirect:/text/queryText/-2";
		}
		return "redirect:/text/queryText/1";
	}

	/**
	 * 产生问题。读取word文档内容返回到产生问题页面 
	 * @param textId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/productQuestion/{textId}")
	public String productQuestion(@PathVariable("textId") Integer textId,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		String type = request.getParameter("types");
		type = type.substring(1);
		Date startDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String startDatestr = format.format(startDate);
		Text text = textService.queryTextByTextId(textId);
		List<String> list = textService.readWordText(textId);
		String content ="";
		for(int i = 0;i<list.size();i++){
			content+=list.get(i);
		}
		model.addAttribute("courseName", text.getCourse().getCourseName());
		model.addAttribute("tittle", text.getTextTitle());
		model.addAttribute("content",content);//课文内容
		model.addAttribute("sentences",list);//课文分段内容
		model.addAttribute("textId",textId);
		model.addAttribute("startDate", startDatestr);//开始出题的时间
		model.addAttribute("types", type);//问题类型
		return "/question/questionProduct";
	}
}
