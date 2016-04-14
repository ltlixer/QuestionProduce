package com.swu.question.service;

import java.util.List;

import com.swu.question.entity.Course;
import com.swu.question.entity.Student;

public interface StudentService {
	/**
	 * 添加 student对象
	 * @param student
	 * @return true 成功  false 失败
	 */
	public boolean addStudent(Student student);
	/**
	 * 查询所有学生
	 * @return
	 */
    public List<Student> listStudent();
    /**
     * 删除指定id学生
     * @param id
     */
    public void deleteStudent(Integer stuId);
   
    
    /**
     * 选择课程
     * @param teaIds  所选课程师的 id
     * @param student  当前学生
     * @return
     */
    public boolean selcetCourse(String[] courseIds,Student student);
    /**
     * 退选课程
     * @param courseId
     * @param stuId
     * @return
     */
    public boolean deleteCourseByStu(int courseId,int stuId);
    /**
     * 
     * @param stuNum
     *          登录账号
     * @param stuPass
     *          登录密码
     * @return
     */
    public Student studentLogin(String stuNum,String stuPass);
    /**
     * @param stuNum
     *          注册账号
     * @return  
     *    true 不存在该账号 false 存在该账号  
     */
    public boolean studentRegisterCheck(String stuNum);
    /**
     * 按照stuId 查询学生
     * @param stuId
     * @return 返回一个Student的对象
     */
    public Student selectStudent(int stuId);
    /**
     * 处理该学生关联的teachers
     * @param stuId
     * @return
     */
   /* public Set<Teacher> selectStudentToTeachers(int stuId);*/
    /**
     * 选择上课教师
     * @param teaIds  所选择教师的 id
     * @param student  当前学生
     * @return
     *//*
    public boolean selcetTeacher(String[] teaIds,Student student);*/
    /**
     * 处理该学生关联的Courses
     * @param stuId
     * @return
     */
    public List<Course> selectStudentToCourses(int stuId);
    /**
     * 处理该学生关联的Courses 记住上一次下拉框选择的courseId  返回时该Id 显示在第一
     * @param stuId
     * @param lastCourseId
     * @return
     */
    public List<Course> selectStudentToCourses(int stuId,int lastCourseId);
    /**
     * 修改student密码
     * @param stuId
     * @param pswd
     * @return
     */
    public boolean studentUpdatePssword(int stuId,String pswd);
    /**
     * 查询学生所选的老师
     * @param stuId
     * @return
     */
  /* public List<Teacher> listTeachers(Integer stuId);*/
    
    
    /**
     * 查询学生所选的课程
     * @param stuId
     * @return
     */
    public List<Course> listCourse(Integer stuId);
    /**
     * 
     * @param student
     * @return
     */
    public boolean updateStudentInfor(Student student);
}
