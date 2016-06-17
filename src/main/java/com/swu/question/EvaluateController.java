package com.swu.question;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;

import com.swu.question.dto.StudentAnswerAnalysis;
import com.swu.question.entity.Answer;
import com.swu.question.entity.Course;
import com.swu.question.entity.EvaluateResult;
import com.swu.question.entity.Log;
import com.swu.question.entity.Question;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.entity.Text;
import com.swu.question.service.AnswerService;
import com.swu.question.service.AssignmentService;
import com.swu.question.service.CourseService;
import com.swu.question.service.EvaluateService;
import com.swu.question.service.QuestionService;
import com.swu.question.service.ScoreAssignmentService;
import com.swu.question.service.StudentService;
import com.swu.question.service.TextService;
import com.swu.question.util.DivideHibernateUtil;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	private TextService textService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ScoreAssignmentService scoreAssignmentService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private AssignmentService assignmentService;

	// 学生端
	@RequestMapping("/stuLinklistText")
	public ModelAndView stuLinklistText(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("link linkAddText page.");
		Student student = (Student) session.getAttribute("stu");
		System.out.println("link");
		List<Course> courses = studentService.selectStudentToCourses(student
				.getStuId());
		if (courses == null || courses.size() == 0) {
			model.addAttribute("courseSize", "0");
		}
		model.addAttribute("pageNow", "0");
		model.addAttribute("sumCount", "0");
		model.addAttribute("link", "first");
		model.addAttribute("user", "stu");
		return new ModelAndView("/evaluate/listText", "courses", courses);
	}

	// 未评估的课文
	@RequestMapping("/queryTextList/{pageNow}")
	public String queryText(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		String resumPage = request.getParameter("sumPage");
		String courseId = request.getParameter("course");
		Student student = (Student) session.getAttribute("stu");
		List<Text> texts = evaluateService.listTexts(
				Integer.parseInt(courseId), student.getStuId());
		DivideHibernateUtil dh = new DivideHibernateUtil();
		int pagesize = dh.getPageSize();
		List<Text> retexts = new ArrayList<Text>();
		if (pageNow == 1) {
			int sumCount = evaluateService.countListTexts(
					Integer.parseInt(courseId), student.getStuId());
			model.addAttribute("sumCount", sumCount);
			if (sumCount == 1) {
				retexts = texts;
			} else {
				System.out.println(pagesize);
				for (int i = 0; i < pagesize && texts.size() >= pagesize - 1; i++) {
					retexts.add(texts.get(i));
				}
			}
		} else {
			model.addAttribute("sumCount", resumPage);
			if (pagesize * pageNow < texts.size()) {
				for (int i = pagesize * (pageNow - 1); i < pagesize * pageNow; i++) {
					retexts.add(texts.get(i));
				}
			} else {
				for (int i = pagesize * (pageNow - 1); i < texts.size(); i++) {
					retexts.add(texts.get(i));
				}
			}
		}
		model.addAttribute("texts", retexts);
		model.addAttribute("pageNow", pageNow);

		// 课程信息查询
		List<Course> courses = studentService.selectStudentToCourses(
				student.getStuId(), Integer.parseInt(courseId));
		if (courses.size() == 0) {
			model.addAttribute("courseSize", "0");
		}
		model.addAttribute("courses", courses);

		return "/evaluate/listText";
	}

	// 已评估的课文
	@RequestMapping("/queryTextListEvaluated/{pageNow}")
	public String queryTextListEvaluated(@PathVariable("pageNow") int pageNow,
			ModelMap model, HttpSession session, HttpServletRequest request) {
		logger.info("link linkAddText page.");
		String resumPage = request.getParameter("sumPage");
		Student student = (Student) session.getAttribute("stu");
		List<Text> texts = evaluateService.listTextsEvaluated(student
				.getStuId());
		DivideHibernateUtil dh = new DivideHibernateUtil();
		int pagesize = dh.getPageSize();
		List<Text> retexts = new ArrayList<Text>();
		if (pageNow == 1) {
			int sumCount = evaluateService.countlistTextsEvaluated(student
					.getStuId());
			model.addAttribute("sumCount", sumCount);
			if (sumCount == 1) {
				retexts = texts;
			} else {
				System.out.println(pagesize);
				for (int i = 0; i < pagesize && texts.size() >= pagesize - 1; i++) {
					retexts.add(texts.get(i));
				}
			}
		} else {
			model.addAttribute("sumCount", resumPage);
			if (pagesize * pageNow < texts.size()) {
				for (int i = pagesize * (pageNow - 1); i < pagesize * pageNow; i++) {
					retexts.add(texts.get(i));
				}
			} else {
				for (int i = pagesize * (pageNow - 1); i < texts.size(); i++) {
					retexts.add(texts.get(i));
				}
			}
		}
		model.addAttribute("texts", retexts);
		model.addAttribute("pageNow", pageNow);
		return "/evaluate/listTextEvaluated";
	}

	// 删除评估结果

	@RequestMapping("/deleteEvaluate/{textId}")
	public String deleteEvaluate(@PathVariable("textId") Integer textId,
			ModelMap model, HttpSession session) {
		Student student = (Student) session.getAttribute("stu");
		evaluateService.deleteEvaluate(textId, student.getStuId());
		return "redirect:/evaluate/queryTextListEvaluated/1";
	}

	/**
	 * 产生问题。读取word文档内容返回到产生问题页面
	 * 
	 * @param textId
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/productQuestion/{textId}")
	public String productQuestion(@PathVariable("textId") Integer textId,
			ModelMap model, HttpSession session) {
		logger.info("link linkAddText page.");
		Date startDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startDatestr = format.format(startDate);
		Text text = textService.queryTextByTextId(textId);
		List<String> list = textService.readWordText(textId);
		String content = "";
		for (int i = 0; i < list.size(); i++) {
			content += list.get(i);
		}
		model.addAttribute("courseName", text.getCourse().getCourseName());
		model.addAttribute("tittle", text.getTextTitle());
		model.addAttribute("content", content);// 课文内容
		model.addAttribute("sentences", list);// 课文分段内容
		model.addAttribute("textId", textId);
		model.addAttribute("startDate", startDatestr);// 开始出题的时间
		return "/evaluate/questionProduct";
	}

	// 保存评估结果
	@RequestMapping("/saveEvaluate")
	public void saveEvaluate(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		logger.info("saveEvaluate.");
		try {
			Student student = (Student) session.getAttribute("stu");
			JSONObject json = JSONObject.fromObject(request
					.getParameter("data"));
			// scores 存放 answerId tOrT
			@SuppressWarnings("unchecked")
			List<Map<String, String>> evaluates = (List<Map<String, String>>) json
					.getJSONArray("evaluates");
			String textId = request.getParameter("textId");
			boolean b = evaluateService.addEvaluateJson(evaluates, textId,
					student);
			if (b) {
				response.getWriter().write("success");
			} else {
				response.getWriter().write("fail");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 教师端
	/**
	 * 链接到评估结果页面
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/linkqueryEvaluated")
	public String linkqueryEvaluated(ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		model.addAttribute("first", "first");
		return "/evaluate/downloadEvaluated";
	}

	// 教师端
	/**
	 * 查询已评估的数据
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/queryEvaluated")
	public String queryEvaluated(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String[] courseIds = request.getParameterValues("courseIds");
		List<EvaluateResult> list = new ArrayList<EvaluateResult>();
		List<Text> textsAll = new ArrayList<Text>();
		Teacher teacher = (Teacher) session.getAttribute("tea");
		for (int i = 0; i < courseIds.length; i++) {
			int courseId = Integer.parseInt(courseIds[i]);
			List<Text> texts = evaluateService.listEvaluated(courseId);
			int countText = evaluateService.countTextByCourseId(courseId + "");// 统计发布的总课程数量
			EvaluateResult evaluateResult = new EvaluateResult();
			evaluateResult.setCountText(countText);
			evaluateResult.setCountEvaluate(texts.size());
			Course course = courseService.listCourseByCourseId(courseId);
			evaluateResult.setCourseName(course.getYear() + "级"
					+ course.getCourseName());
			evaluateResult.setTeaName(teacher.getTeaName());
			if (texts != null && texts.size() > 0) {
				for (int j = 0; j < texts.size(); j++) {
					textsAll.add(texts.get(j));
				}
			}

			list.add(evaluateResult);
		}
		model.addAttribute("texts", textsAll);
		model.addAttribute("list", list);
		String courseId = courseIds[0];
		for (int i = 1; i < courseIds.length; i++) {
			courseId += "-" + courseIds[i];
		}
		model.addAttribute("courseIds", courseId);
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		return "/evaluate/downloadEvaluated";
	}

	// 教师端
	/**
	 * 下载已评估的数据
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/downloadEvaluated")
	public String downloadEvaluated(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String courseIds = request.getParameter("courseIds");
		String[] ids = courseIds.split("-");
		String fileName = "evaluate.xlsx";
		String path = request.getSession().getServletContext()
				.getRealPath("/resources/evaluate/");
		evaluateService.downloadEvaluated(ids, response, path, fileName);
		return null;
	}

	/**
	 * 以下为：
	 * 日志管理
	 * 
	 */
	@RequestMapping("/linkqueryLogTea")
	public String linkqueryLogTea(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		model.addAttribute("first", "first");
		return "/evaluate/downloadLogTea";
	}

	@RequestMapping("/linkqueryLogStu")
	public String linkqueryLogStu(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		model.addAttribute("first", "first");
		return "/evaluate/downloadLogStu";
	}
	/**
	 * 下载学生做题日志
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/downlogStu")
	public String downloadLogStu(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String[] courseIds = request.getParameterValues("courseIds");
		String fileName = "logStudent.xlsx";
		String path = request.getSession().getServletContext()
				.getRealPath("/resources/evaluate/");
		evaluateService.downloadLogStu(courseIds, response, path, fileName);
		return null;
	}
	/**
	 * 查看学生做题日志详细
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/viewlogStu")
	public String viewLogStu(ModelMap model, HttpServletRequest request,
			 HttpSession session) {
		String courseId = request.getParameter("courseIds").substring(1);
		String[] courseIds  = courseId.split("-");
		List<Log> logs = evaluateService.queryLogStu(courseIds);
		model.addAttribute("logs", logs);
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		model.addAttribute("first", "secend");
		return "/evaluate/downloadLogStu";
	}
	/**
	 * 下载所有学生某次作业的答题记录
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/downloadStuAnswer/{assId}")
	public String downloadStuAnswer(@PathVariable("assId")int assId,ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String[] courseIds = request.getParameterValues("courseIds");
		String fileName = "学生答题记录.xlsx";
		String path = request.getSession().getServletContext()
				.getRealPath("/resources/evaluate/");
		evaluateService.downloadStuAnswer(assId, response, path, fileName);
		return null;
	}
	/**
	 * 查看所有学生某次作业的答题记录
	 * @return
	 */
	@RequestMapping("/viewStuAnswer/{assId}")
	public String viewStuAnswer(@PathVariable("assId")int assId,ModelMap model, HttpServletRequest request,
			 HttpSession session){
		List<StudentAnswerAnalysis> studentAnswerAnalysisList = new ArrayList<StudentAnswerAnalysis>();
		List<Question> questionList = questionService.queryQuestionsByassId(assId);
		Set<Student> studentList = assignmentService.getAssignment(assId).getText().getCourse().getStudents();
		for(Question question:questionList){
			for(Student student:studentList){
				StudentAnswerAnalysis studentAnswerAnalysis = new StudentAnswerAnalysis();
				studentAnswerAnalysis.setQuestionId(question.getqId());
				studentAnswerAnalysis.setQuestionName(question.getQuestion());
				studentAnswerAnalysis.setSystemAnswer(question.getAnswer());
				studentAnswerAnalysis.setQuestionType(question.getQuestionType());
				studentAnswerAnalysis.setStudentName(student.getStuName());
				studentAnswerAnalysis.setStudentGrade(student.getGrade()+"");
				List<Answer> answers = answerService.queryAnswers(question.getqId(), student.getStuId());
				if(answers!=null&&answers.size()>0){
					studentAnswerAnalysis.setStudentAnswer(answers.get(0).getAnswer());
					studentAnswerAnalysis.settORf(answers.get(0).gettOrF());
				}else{
					studentAnswerAnalysis.setStudentAnswer("null");
					studentAnswerAnalysis.settORf("null");
				}
				studentAnswerAnalysisList.add(studentAnswerAnalysis);
			}
		}
		model.addAttribute("studentAnswerAnalysisList",studentAnswerAnalysisList);
		model.addAttribute("assId", assId);
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		model.addAttribute("first", "thrid");
		return "/evaluate/downloadLogStu";
	}
	/**
	 * 下载教师出题日志
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/downlogTea")
	public String downloadLogTea(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String[] courseIds = request.getParameterValues("courseIds");
		String fileName = "logTeacher.xlsx";
		String path = request.getSession().getServletContext()
				.getRealPath("/resources/evaluate/");
		evaluateService.downloadLogTea(courseIds, response, path, fileName);
		return null;
	}
	
	@RequestMapping("/viewlogTea")
	public String viewLogTea(ModelMap model, HttpServletRequest request,
			 HttpSession session) {
		String courseId = request.getParameter("courseIds").substring(1);
		String[] courseIds  = courseId.split("-");
		List<Log> logs = evaluateService.queryLogTea(courseIds);
		model.addAttribute("logs", logs);
		Teacher teacher = (Teacher) session.getAttribute("tea");
		List<Course> courses = courseService.listCourseByTeaId(teacher
				.getTeaId());
		model.addAttribute("courses", courses);
		return "/evaluate/downloadLogStu";
	}
}
