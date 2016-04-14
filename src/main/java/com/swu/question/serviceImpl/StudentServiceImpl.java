package com.swu.question.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.CourseDAO;
import com.swu.question.dao.StudentDAO;
import com.swu.question.dao.TeacherDAO;
import com.swu.question.entity.Course;
import com.swu.question.entity.Student;
import com.swu.question.service.StudentService;

/**
 * 
 * @author yanhao
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	@Transactional
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			studentDAO.addStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return studentDAO.listStudent();
	}

	@Override
	@Transactional
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
	}

	@Override
	@Transactional
	public Student studentLogin(String stuNum, String stuPass) {
		// TODO Auto-generated method stub
		List<Student> list = studentDAO.studentLogin(stuNum, stuPass);
		Student student = null;
		if (list != null) {
			if (list.size() > 0) {
				student = list.get(0);
			}
		}
		return student;
	}

	@Override
	@Transactional
	public boolean studentRegisterCheck(String stuNum) {
		// TODO Auto-generated method stub
		List<Student> list = studentDAO.listStudent();
		if (list != null && list.size() > 0) {
			for (Student stu : list) {
				if (stu.getStuNum().equals(stuNum)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean studentUpdatePssword(int stuId, String pswd) {
		// TODO Auto-generated method stub
		try {
			studentDAO.updatePassword(stuId, pswd);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * @Override
	 * 
	 * @Transactional public List<Teacher> listTeachers(Integer stuId) { // TODO
	 * Auto-generated method stub Set<Teacher> set =
	 * studentDAO.listTeachers(stuId); List<Teacher> list = new
	 * ArrayList<Teacher>(); Iterator<Teacher> tea = set.iterator(); while
	 * (tea.hasNext()) { Teacher t = (Teacher) tea.next(); list.add(t); } return
	 * list; }
	 */
	@Override
	@Transactional
	public List<Course> listCourse(Integer stuId) {
		// TODO Auto-generated method stub
		Set<Course> set = studentDAO.listCourse(stuId);
		List<Course> list = new ArrayList<Course>();
		Iterator<Course> course = set.iterator();
		while (course.hasNext()) {
			Course t = (Course) course.next();
			list.add(t);
		}
		return list;
	}

	@Override
	@Transactional
	public Student selectStudent(int stuId) {
		// TODO Auto-generated method stub
		List<Student> studentList = studentDAO.selectStudent(stuId);
		return studentList.get(0);
	}

	@Override
	@Transactional
	public boolean updateStudentInfor(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudentInfor(student);
	}

	@Override
	@Transactional
	public List<Course> selectStudentToCourses(int stuId) {
		// TODO Auto-generated method stub
		List<Student> listStudent = studentDAO.selectStudent(stuId);
		Set<Course> courses = listStudent.get(0).getCourse();
		List<Course> list = new ArrayList<Course>();
		Iterator<Course> course = courses.iterator();
		while (course.hasNext()) {
			Course t = (Course) course.next();
			list.add(t);
		}
		Collections.sort(list, new Comparator<Course>() {
			public int compare(Course o1, Course o2) {
				if (o1.getCourseId().compareTo(o2.getCourseId()) > 0) {
					return 1;
				}
				return -1;
			}
		});
		return list;
	}

	// 处理该学生关联的Courses 记住上一次下拉框选择的courseId 返回时该Id 显示在第一
	@Override
	public List<Course> selectStudentToCourses(int stuId, int lastCourseId) {
		// TODO Auto-generated method stub
		List<Student> listStudent = studentDAO.selectStudent(stuId);
		Set<Course> courses = listStudent.get(0).getCourse();
		List<Course> list = new ArrayList<Course>();
		Iterator<Course> course = courses.iterator();
		Course firstCourse = new Course();
		while (course.hasNext()) {
			Course t = (Course) course.next();
			if (lastCourseId != t.getCourseId()) {
				list.add(t);
			} else {
				firstCourse = t;
			}

		}
		// 排除 按 courseId 排序
		Collections.sort(list, new Comparator<Course>() {
			public int compare(Course o1, Course o2) {
				if (o1.getCourseId().compareTo(o2.getCourseId()) > 0) {
					return 1;
				}
				return -1;
			}
		});
		list.add(0, firstCourse);// 把上一次的course放在第一行
		return list;
	}

	/*
	 * @Override
	 * 
	 * @Transactional public Set<Teacher> selectStudentToTeachers(int stuId) {
	 * // TODO Auto-generated method stub List<Student> listStudent =
	 * studentDAO.selectStudent(stuId); Set<Teacher> teachers =
	 * listStudent.get(0).getTeachers(); return teachers; }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public boolean selcetTeacher(String[] teaIds, Student
	 * student){ // TODO Auto-generated method stub return false; }
	 */

	@Override
	@Transactional
	public boolean selcetCourse(String[] courseIds, Student student) {
		// TODO Auto-generated method stub
		try {
			List<Course> listCourse = courseDAO.listCourse();
			Set<Course> courseList = new HashSet<Course>();
			// 查询当前的学生
			Student student2 = studentDAO.selectStudent(student.getStuId())
					.get(0);
			// 得到当前学生所选的课程
			Set<Course> courses = student2.getCourse();
			// 加入学生已经选择过的课程
			Iterator<Course> cou = courses.iterator();// 先迭代出来
			while (cou.hasNext()) {// 遍历
				Course course = (Course) cou.next();
				courseList.add(course);
			}
			for (int i = 0; i < courseIds.length; i++) {
				for (int j = 0; j < listCourse.size(); j++) {
					if (courseIds[i].equals(listCourse.get(j).getCourseId()
							+ "")) {
						courseList.add(listCourse.get(j));
					}
				}
			}
			if (courseList != null && courseList.size() > 0) {
				studentDAO.updateStudentForSelectCouse(student.getStuId(),
						courseList);
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	/**
	 * 退选课程
	 */
	@Override
	@Transactional
	public boolean deleteCourseByStu(int courseId, int stuId) {
		// TODO Auto-generated method stub
		try {

			Set<Course> courseList = new HashSet<Course>();
			Student student = studentDAO.selectStudent(stuId).get(0);
			// 得到当前学生所选的课程
			Set<Course> courses = student.getCourse();
			// 加入学生已经选择过的课程
			Iterator<Course> cou = courses.iterator();// 先迭代出来
			while (cou.hasNext()) {// 遍历
				Course course = (Course) cou.next();
				if(course.getCourseId()!=courseId){
					courseList.add(course);
				}
			}
			System.out.println(courseList.size());
			studentDAO.updateStudentForSelectCouse(student.getStuId(),
						courseList);
				/*studentDAO.updateStudentForDeleteCouse(stuId, cous);*/
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

}
