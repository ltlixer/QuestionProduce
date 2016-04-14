package com.swu.question.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	@Id
    @Column(name="COURSEID")
    @GeneratedValue
	private Integer courseId;
	@Column(name="COURSERNAME",nullable=false,length=30)
	private String courseName;
	@Column(name="YEAR",nullable=false,length=10) 
	private String year; 
	
	@Column(name="STATE",nullable=false,columnDefinition="INT default 1") 
	private Integer state; 
	//course -- teacher n:1
	@ManyToOne
	@JoinColumn(name="TEA_ID",referencedColumnName="teaId",nullable=false)
	 private Teacher teacher;
	
	@ManyToMany(mappedBy = "course")
	private Set<Student> students;
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
}
