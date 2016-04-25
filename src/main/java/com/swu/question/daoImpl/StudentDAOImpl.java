package com.swu.question.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swu.question.dao.StudentDAO;
import com.swu.question.entity.Course;
import com.swu.question.entity.Student;

/**
 * 实现Student实体类的数据库操作
 * 
 * @author 严浩
 *
 */

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session
					.createQuery("from Student stu where stu.stuNum=?");
			q.setString(0, student.getStuNum());
			if (q.list().size() > 0) {
				return false;
			}
			sessionFactory.getCurrentSession().save(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Student> list = sessionFactory.getCurrentSession()
				.createQuery("From Student").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> studentLogin(String stuNum, String stuPass) {
		// TODO Auto-generated method stub
		Query q = sessionFactory.getCurrentSession().createQuery(
				"From Student s Where s.stuNum=? and s.stuPassword=?");
		q.setString(0, stuNum);
		q.setString(1, stuPass);
		List<Student> list = q.list();
		return list;
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		Student student = (Student) sessionFactory.getCurrentSession().load(
				Student.class, id);
		if (null != student) {
			sessionFactory.getCurrentSession().delete(student);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> selectStudent(int stuId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Student stu where stu.stuId=?");
		q.setInteger(0, stuId);
		List<Student> list = q.list();
		return list;
	}

	@Override
	public void updatePassword(Integer stuId, String pswd) {
		// TODO Auto-generated method stub
		Student student = (Student) sessionFactory.getCurrentSession().load(
				Student.class, stuId);
		if (null != student) {
			student.setStuPassword(pswd);
			sessionFactory.getCurrentSession().update(student);
		}
	}

	/*@Override
	public Set<Teacher> listTeachers(Integer stuId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Student s where s.stuId = ?");
		q.setParameter(0, stuId);
		Student student = (Student) q.list().get(0);
		Set<Teacher> teachers = student.getTeachers();
		return teachers;
	}*/
	@Override
	public Set<Course> listCourse(Integer stuId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"from Student s where s.stuId = ?");
		q.setParameter(0, stuId);
		Student student = (Student) q.list().get(0);
		Set<Course> courses = student.getCourse();
		return courses;
	}
	@Override
	public boolean updateStudentInfor(Student stu) {
		// TODO Auto-generated method stub
		try {
			Student student = (Student) sessionFactory.getCurrentSession()
					.load(Student.class, stu.getStuId());
			if (null != student) {
				student.setStuEmail(stu.getStuEmail());
				sessionFactory.getCurrentSession().update(student);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void updateStudentForSelectCouse(Integer stuId, Set<Course> courses) {
		// TODO Auto-generated method stub
		Student student = (Student) sessionFactory.getCurrentSession().load(
				Student.class, stuId);
		if (null != student) {
			student.setCourse(courses);
			sessionFactory.getCurrentSession().update(student);
		}
	}

	@Override
	public List<Student> getStudentByNum(String stuNum) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Student stu where stu.stuNum=?");
		q.setString(0, stuNum);
		@SuppressWarnings("unchecked")
		List<Student> list = q.list();
		return list;
	}

}
