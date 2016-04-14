package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Teacher;

public interface TeacherDAO {
	/**
	 * 
	 * @param teaNum
	 * @param teaPass
	 * @return
	 */
	public List<Teacher> teacherLogin(String teaNum, String teaPass);

	/**
	 * 
	 * @param teadent
	 */
	public void addTeacher(Teacher teadent);

	/**
	 * 
	 * @param id
	 */
	public void deleteTeacher(Integer id);

	/**
	 * 
	 * @param id
	 * @param pswd
	 */
	public void updatePassword(Integer id, String pswd);

	/**
	 * 
	 * @param teacher
	 */
	public void updateTeacherInfor(Teacher teacher);

	/**
	 * 
	 * @param teaId
	 * @return
	 */
	public List<Teacher> queryTeacher(int teaId);

	/**
	 * 
	 * @return
	 */
	public List<Teacher> listTeacher();

	/**
	 * 
	 * @param pageNow
	 * @return
	 *//*
	public List<Teacher> listTeacher(int pageNow);

	*//**
	 * 
	 * @return
	 *//*
	public int listTeacher1();*/

}
