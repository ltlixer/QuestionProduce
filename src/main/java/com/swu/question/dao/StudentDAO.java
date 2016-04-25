package com.swu.question.dao;

import java.util.List;
import java.util.Set;

import com.swu.question.entity.Course;
import com.swu.question.entity.Student;




public interface  StudentDAO {
	/**
	 * 
	 * @param stuNum
	 * @param stuPass
	 * @return
	 */
	public List<Student> studentLogin(String stuNum,String stuPass);
	/**
	 * 
	 * @param student
	 */
	public boolean addStudent(Student student);
	/**
	 * 
	 * @return
	 */
    public List<Student> listStudent();
    /**
     * 
     * @param stuId
     */
    public void deleteStudent(Integer stuId);
    /**
     * delete  ....
     * @param stuId
     * @param teachers
     */
    /*public void updateStudentForSelectTea(Integer stuId,Set<Teacher> teachers);*/
    /**
     * 
     * @param stuId
     * @param courses
     */
    public void updateStudentForSelectCouse(Integer stuId,Set<Course> courses);
    
    /**
     * 
     * @param stuId
     * @return
     */
    public List<Student> selectStudent(int stuId); 
    /**
     * 
     * @param stuId
     * @param pswd
     */
    public void updatePassword(Integer stuId,String pswd);
    /**
	 * 
	 * @param teacher
	 */
	public boolean updateStudentInfor(Student student);
	
	 /**
     * 
     * @param stuId
     * @return
     */
    public Set<Course> listCourse(Integer stuId);

    /**
     * 
     * @param stuId
     * @return
     */
   /* public Set<Teacher> listTeachers(Integer stuId);*/
    public List<Student> getStudentByNum(String stuNum);
}
