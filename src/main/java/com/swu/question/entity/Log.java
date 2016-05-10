package com.swu.question.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "LOG")
public class Log {
	@Id
	@Column(name = "LogId")
	@GeneratedValue
	private Integer logId;
	@Column(name = "questionType", nullable = false)
	private String questionType;
	@Column(name = "startTime", nullable = false)
	private Date startTime;
	@Column(name = "endTime", nullable = false)
	private Date endTime;
	@Column(name = "useTime", nullable = false)
	private long useTime;
	
	@ManyToOne
	@JoinColumn(name="ass_ID",referencedColumnName="assId",nullable=false)
	private Assignment assignment;
	
	
	@Column(name = "stuId")
	private Integer stuId;
	@Column(name = "teaId")
	private Integer teaId;
	@Column(name = "user")
	private String user;
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public long getUseTime() {
		return useTime;
	}
	public void setUseTime(long useTime) {
		this.useTime = useTime;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public Integer getTeaId() {
		return teaId;
	}
	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
