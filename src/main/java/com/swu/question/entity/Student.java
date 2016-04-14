package com.swu.question.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
    @Column(name="STUID")
    @GeneratedValue
	private Integer stuId;
	 @Column(name="STUNUM",unique=true,length=30)
	 @NotEmpty(message="用户名不能为空")
	private String stuNum;
	 @Column(name="STUNAME",nullable=false,length=30)
	private String stuName;
	 @Column(name="STUPASSWORD",nullable=false,length=30)
	 @NotEmpty(message="密码不能为空")
	private String stuPassword;
	 @Column(name="STUEMAIL",length=30)
	private String stuEmail;
	 @Column(name="GRADE",nullable=false,length=10)
	 private double grade;
	 //teacher - student  n:n
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_teacher", 
	joinColumns={@JoinColumn(name="student_id")},
	inverseJoinColumns={@JoinColumn(name="teacher_id")})
	 private Set<Teacher> teachers;*/
	 
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course", 
	joinColumns={@JoinColumn(name="student_id")},
	inverseJoinColumns={@JoinColumn(name="course_id")})
	 private Set<Course> course;
	 	
	 public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	
	
}
