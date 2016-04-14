package com.swu.question.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {
	@Id
	@Column(name = "TEAID")
	@GeneratedValue
	private Integer teaId;
	@Column(name = "TEANUM",unique=true,nullable=false,length=30)
	private String teaNum;
	@Column(name = "TEANAME",nullable=false,length=30)
	private String teaName;
	@Column(name = "TEAPASSWORD",nullable=false,length=30)
	private String teaPassword;
	@Column(name = "TEAEMAIL",nullable=false,length=30)
	private String teaEmail;
	@Column(name = "TEAMAJOR",nullable=false,length=30)
	private String teaMajor;


	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public String getTeaNum() {
		return teaNum;
	}

	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaPassword() {
		return teaPassword;
	}

	public void setTeaPassword(String teaPassword) {
		this.teaPassword = teaPassword;
	}

	public String getTeaEmail() {
		return teaEmail;
	}

	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
	}

	public String getTeaMajor() {
		return teaMajor;
	}

	public void setTeaMajor(String teaMajor) {
		this.teaMajor = teaMajor;
	}

	
}
