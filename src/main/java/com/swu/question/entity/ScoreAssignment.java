package com.swu.question.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "ScoreAssignment")
public class ScoreAssignment {
	@Id
	@Column(name = "SAID")
	@GeneratedValue
	private Integer saId;
	@Column(name = "SCORE")
	private double score;
	@Column(name = "USETIME")
	private Integer useTime;
	@Column(name = "CREATTIME")
	private Date createTime; 
	@Column(name = "EVALUATE")
	private String evaluate;
	@Column(name = "CORRECT")
	private int correct;
	// testScore -- Student n:1
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "STU_ID", referencedColumnName = "stuId",nullable=false)
	private Student student;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ASS_ID", referencedColumnName = "assId",nullable=false)
	private Assignment assignment;

	public Integer getSaId() {
		return saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Integer getUseTime() {
		return useTime;
	}

	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

}
