package com.swu.question.service;

import java.util.List;

import com.swu.question.entity.Course;
import com.swu.question.entity.Teacher;

public interface CourseService {
	/**
	 * 查询所有的课程
	 * @return
	 */
	public List<Course> listCourse();
	
	/**
	 * 查询所有course
	 * @param pageNow 
	 * @return
	 */
    public List<Course> listCourse(int pageNow);
    public int countListCourse();
	/**
	 * 根据教师发布的课程
	 * @param teaId
	 * @return
	 */
	public List<Course> listCourseByTeaId(Integer teaId);
	/**
	 * 添加某位老师的课程
	 * @param course
	 * @param teacher
	 * @return
	 */
	public boolean addCourse(Course course,Teacher teacher);
	/**
	 * 根据课程id删除老师的课程
	 * @param courseId
	 * @return
	 */
	public boolean deleteCourse(Integer courseId);
	
	//===
	public Course listCourseByCourseId(int courseId);
}
