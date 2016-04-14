package com.swu.question.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.swu.question.dao.StudentDAO;
import com.swu.question.dao.TeacherDAO;
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
			/*// 查询需要的学生
			Student student = studentDAO.selectStudent(stuId).get(0);
			// 得到当前学生所选的老师
			Set<Teacher> teachers = student.getTeachers();
			Set<Teacher> temTeachers = new HashSet<Teacher>();
			Iterator<Teacher> tea = teachers.iterator();// 先迭代出来
			while (tea.hasNext()) {// 遍历
				Teacher teacher = (Teacher) tea.next();
				if (teacher.getTeaId() != teaId) {
					temTeachers.add(teacher);
				}
			}
			System.out.println(temTeachers.size());
			if (temTeachers != null) {
				studentDAO.updateStudentForSelectTea(stuId, temTeachers);*/
				studentDAO.deleteStudent(stuId);
			/*}*/
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
			Teacher teacher) {
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
						 for(int i = 0;i<list.size();i++){
							 Student stu = list.get(i);
							/* stu.setTeachers(teachers);*/
							boolean d= studentDAO.addStudent(stu);
							if(d){
								count++;
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

}
