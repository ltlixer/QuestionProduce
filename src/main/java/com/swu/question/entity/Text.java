package com.swu.question.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEXT")
public class Text {
	@Id
	@Column(name = "TEXTID")
	@GeneratedValue
	private Integer textId;
	@Column(name = "TEXTTITLE",nullable=false,length=100)
	private String textTitle;
	@Column(name = "TEXTURL",nullable=false)
	private String textURL;
	@Column(name = "TEXNAME",nullable=false)
	private String textName;
/*	@Column(name = "TEXTTIME")
	private Integer textTime;*/
	@Column(name = "CREATETIME",nullable=false)
	private Date createTime;
	
	@ManyToOne
	@JoinColumn(name = "course_ID", referencedColumnName = "courseId",nullable=false)
	private Course course;
	
	// text -- teacher n:1
	@ManyToOne
	@JoinColumn(name = "TEA_ID", referencedColumnName = "teaId",nullable=false)
	private Teacher teacher;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "text")
	private Set<NewWords> newWords;
	
	
	public Set<NewWords> getNewWords() {
		return newWords;
	}

	public void setNewWords(Set<NewWords> newWords) {
		this.newWords = newWords;
	}

	public Integer getTextId() {
		return textId;
	}

	public void setTextId(Integer textId) {
		this.textId = textId;
	}

	public String getTextTitle() {
		return textTitle;
	}

	public void setTextTitle(String textTitle) {
		this.textTitle = textTitle;
	}

	public String getTextName() {
		return textName;
	}

	public void setTextName(String textName) {
		this.textName = textName;
	}

	public String getTextURL() {
		return textURL;
	}

	public void setTextURL(String textURL) {
		this.textURL = textURL;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
