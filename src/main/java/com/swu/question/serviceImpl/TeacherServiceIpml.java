package com.swu.question.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.swu.question.dao.AnswerDAO;
import com.swu.question.dao.CourseDAO;
import com.swu.question.dao.ScoreAssignmentDAO;
import com.swu.question.dao.StudentDAO;
import com.swu.question.dao.TeacherDAO;
import com.swu.question.entity.Answer;
import com.swu.question.entity.Course;
import com.swu.question.entity.ScoreAssignment;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.service.TeacherService;
import com.swu.question.util.DeleteFile;
import com.swu.question.util.ExcelBean;
import com.swu.question.util.UploadDownloadFile;

/**
 * 
 * @author yanhao
 *
 */
@Service
public class TeacherServiceIpml implements TeacherService {
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private ScoreAssignmentDAO scoreAssignmentDAO;
	@Autowired
	private AnswerDAO answerDAO;

	@Override
	@Transactional
	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			teacherDAO.addTeacher(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public void deleteTeacher(Integer id) {
		// TODO Auto-generated method stub
		teacherDAO.deleteTeacher(id);
	}

	@Override
	@Transactional
	public Teacher teacherLogin(String teaNum, String teaPass) {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDAO.teacherLogin(teaNum, teaPass);
		Teacher teacher = null;
		if (list != null) {
			if (list.size() > 0) {
				teacher = list.get(0);
			}
		}
		return teacher;
	}

	@Override
	@Transactional
	public boolean teacherRegisterCheck(String teaNum) {
		// TODO Auto-generated method stub
		List<Teacher> list = teacherDAO.listTeacher();
		if (list != null && list.size() > 0) {
			for (Teacher tea : list) {
				if (tea.getTeaNum().equals(teaNum)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean teacherUpdatePssword(int teaId, String pswd) {
		// TODO Auto-generated method stub
		try {
			teacherDAO.updatePassword(teaId, pswd);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	@Transactional
	public boolean updateTeacherInfor(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			teacherDAO.updateTeacherInfor(teacher);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Teacher queryTeacher(int teaId) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDAO.queryTeacher(teaId).get(0);
		return teacher;
	}

	/*@Override
	@Transactional
	public Set<Student> queryTeacherToStudent(int teaId) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherDAO.queryTeacher(teaId).get(0);
		Set<Student> students = teacher.getStudents();
		return students;
	}*/

	@Override
	@Transactional
	public boolean removeStudentBystuId(int teaId, int stuId) {
		// TODO Auto-generated method stub
		try {
			// 查询需要的学生
			Student student = studentDAO.selectStudent(stuId).get(0);
			List<ScoreAssignment> scoreAssignments = scoreAssignmentDAO.listScoreAssignmentBystuId(stuId);
			if(null != scoreAssignments){
				for(ScoreAssignment sa:scoreAssignments){
					List<Answer> answers = answerDAO.queryAnswerByscoreAssId(sa.getSaId());
					for(Answer a:answers)
						answerDAO.deleteAnswer(a.getAsswerId());
					scoreAssignmentDAO.deleteScoreAssignment(sa.getSaId());
					//scoreAssignments.remove(sa);
				}
			}
			
			Set<Course> courses = new HashSet<Course>();
			 studentDAO.updateStudentForSelectCouse(student.getStuId(),courses);
				studentDAO.deleteStudent(stuId);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*@Override
	@Transactional
	public int listTeacher1() {
		// TODO Auto-generated method stub
		return teacherDAO.listTeacher1();
	}

	@Override
	@Transactional
	public List<Teacher> listTeacher(int pageNow) {
		// TODO Auto-generated method stub
		return teacherDAO.listTeacher(pageNow);
	}*/

	@Override
	@Transactional
	public List<Teacher> listTeacher() {
		// TODO Auto-generated method stub
		return teacherDAO.listTeacher();
	}

	@Override
	@Transactional
	public String addStudents(MultipartFile file, String savePath,
			Teacher teacher,String courseId) {
		// TODO Auto-generated method stub
		try {
			UploadDownloadFile uploadFile = new UploadDownloadFile();
			// 文件上传
			String message = uploadFile.uploadfile(file, savePath);
			System.out.println(message);
			if (message.equals("NoFile")) {
				return "NoFile";
			} else if (message.equals("error")) {
				return "upError";
			}else{
				 List<Student> list =null;
				 int count=0;
				String path = savePath + "\\" + message;
				if (message.substring(message.indexOf(".") + 1).equals("xlsx")
						|| message.substring(message.indexOf(".") + 1).equals(
								"xls")) {
					ExcelBean excellBea = new ExcelBean();
					list =excellBea.getStudentNumAndGrade(path);
					 Set<Teacher> teachers = new HashSet<Teacher>();
						teachers.add(teacher);
						if(list.size()>0){
							Course course = courseDAO.selectCourseById(Integer.parseInt(courseId));
							Set<Course> courses = new HashSet<Course>();
							courses.add(course);
							for(int i = 0;i<list.size();i++){
							 Student stu = list.get(i);
							 stu.setCourse(courses);
							/* stu.setTeachers(teachers);*/
							boolean d= studentDAO.addStudent(stu);
							if(d){
								count++;
							}else{
								Student s = studentDAO.getStudentByNum(stu.getStuNum()).get(0);
								s.getCourse().add(course);
							}
						 }
					 }else{
						 return "文件中可能不存在【学号】【姓名】【成绩】字段";
					 }
				}else{
					return "不是Excell文件";
				}
			//删除文件
			 DeleteFile deleteFile = new DeleteFile();
			 deleteFile.deleteFile(path); 
			 if(count==0){
				 return "该信息已存在";
			 }
			 return "成功添加"+count+"条数据";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		//return null;
	}

	@Override
	public String downloadStudentExcel(HttpServletResponse response,
			String path, String fileName) {
		// TODO Auto-generated method stub
		UploadDownloadFile uploadFile = new UploadDownloadFile();
		try {
			String re =  uploadFile.download(response,path, fileName);
			System.out.println("下载StudentExcelTem："+re);
			return re;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}

}
