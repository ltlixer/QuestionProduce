package com.swu.question.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swu.question.dao.CourseDAO;
import com.swu.question.dao.StudentDAO;
import com.swu.question.dao.TextDAO;
import com.swu.question.entity.Course;
import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;
import com.swu.question.entity.Text;
import com.swu.question.service.CourseService;
import com.swu.question.util.DivideHibernateUtil;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private TextDAO textDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Override
	@Transactional
	public List<Course> listCourse() {
		// TODO Auto-generated method stub
		return courseDAO.listCourse();
	}

	@Override
	@Transactional
	public List<Course> listCourseByTeaId(Integer teaId) {
		// TODO Auto-generated method stub
		List<Course> newList = new ArrayList<Course>();
		List<Course> list = courseDAO.listCourse();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getTeacher().getTeaId();
			if (id == teaId) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}

	@Override
	@Transactional
	public boolean addCourse(Course course, Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			course.setTeacher(teacher);
			course.setState(1);
			courseDAO.addCourse(course);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	@Transactional
	public boolean deleteCourse(Integer courseId) {
		// TODO Auto-generated method stub
		try {
			List<Text> list = textDAO.listTextByCourseId(courseId);
			if(list!=null&&list.size()>0){
				courseDAO.stopCourse(courseId);
			}else{
				Course course = courseDAO.selectCourseById(courseId);
				Set<Student> stu = course.getStudents();
				Iterator<Student> student = stu.iterator();
				while (student.hasNext()) {
					Student t = (Student) student.next();
					 t.getCourse().remove(course);
					 studentDAO.updateStudentForSelectCouse(t.getStuId(), t.getCourse());
				}
				
				//删除课程
				courseDAO.deleteCourse(courseId);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<Course> listCourse(int pageNow) {
		// TODO Auto-generated method stub
		return courseDAO.listCourse(pageNow);
	}

	@Override
	public int countListCourse() {
		// TODO Auto-generated method stub
		int size = courseDAO.listCourse().size();
		DivideHibernateUtil dhu = new DivideHibernateUtil();
		int pageCount = dhu.getPageCount(size);
		return pageCount;
	}

	@Override
	public Course listCourseByCourseId(int courseId) {
		// TODO Auto-generated method stub
		
		return courseDAO.selectCourseById(courseId);
	}


}
