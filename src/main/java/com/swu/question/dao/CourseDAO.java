package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Course;

public interface CourseDAO {
	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course course);
	/**
	 * 
	 * @return
	 */
    public List<Course> listCourse();
    /**
	 * 
	 * @return
	 */
    public List<Course> listCourse(int pageNow);
    /**
     * 
     * @param id
     */
    public void deleteCourse(Integer id);
    
    public void stopCourse(Integer id);
    
    /**
     * 
     * @param courseId
     * @return
     */
    public Course selectCourseById(int courseId);
}
