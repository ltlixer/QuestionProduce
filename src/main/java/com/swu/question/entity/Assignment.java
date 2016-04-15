package com.swu.question.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assignment")
public class Assignment {
	@Id
	@Column(name = "ASSID")
	@GeneratedValue
	private Integer assId;
	@Column(name = "ASSNAME", nullable = false)
	private String assName;
	@Column(name = "ASSTIME", nullable = false)
	private Integer assTime;
	
	//开始出题开始时间
	@Column(name = "startDate", nullable = false)
	private Date startDate;
	//发布题目的结束时间
	@Column(name = "CREATETIME", nullable = false)
	private Date createTime;
	
	@ManyToOne(targetEntity = Text.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "TEXT_ID", referencedColumnName = "textId", nullable = false)
	private Text text;
	@ManyToOne(targetEntity = Teacher.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "TEA_ID", referencedColumnName = "teaId", nullable = false)
	private Teacher teacher;
	public Integer getAssId() {
		return assId;
	}

	public String getAssName() {
		return assName;
	}

	public void setAssName(String assName) {
		this.assName = assName;
	}

	public void setAssId(Integer assId) {
		this.assId = assId;
	}

	public Integer getAssTime() {
		return assTime;
	}

	public void setAssTime(Integer assTime) {
		this.assTime = assTime;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}



	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
