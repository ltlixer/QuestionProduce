package com.swu.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EVALUATE")
public class Evaluate {
	@Id
    @Column(name="evaluateId")
    @GeneratedValue
	private Integer evaluateId;
	@Column(name="sentenceId",nullable=false)
	private Integer sentenceId;
	@Column(name="sentece",nullable=false)
	private String sentece;
	@Column(name="question",nullable=false)
	private String question;
	@Column(name="answer",nullable=false)
	private String answer;
	@Column(name="Feature1",nullable=false)
	private Integer Feature1;
	@Column(name="Feature2",nullable=false)
	private Integer Feature2;
	@Column(name="Feature3",nullable=false)
	private Integer Feature3;
	@Column(name="Feature4",nullable=false)
	private Integer Feature4;
	@Column(name="Feature5",nullable=false)
	private Integer Feature5;
	@Column(name="tOrF",nullable=false)
	private Integer tOrF;
	@Column(name="Description")
	private String description;
	@ManyToOne
	@JoinColumn(name="Text_ID",referencedColumnName="textId",nullable=false)
	private Text text;
	@ManyToOne
	@JoinColumn(name="STU_ID",referencedColumnName="stuId",nullable=false)
	private Student student;
	
	public Integer getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}
	public Integer getSentenceId() {
		return sentenceId;
	}
	public void setSentenceId(Integer sentenceId) {
		this.sentenceId = sentenceId;
	}
	
	public String getSentece() {
		return sentece;
	}
	public void setSentece(String sentece) {
		this.sentece = sentece;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getFeature1() {
		return Feature1;
	}
	public void setFeature1(Integer feature1) {
		Feature1 = feature1;
	}
	public Integer getFeature2() {
		return Feature2;
	}
	public void setFeature2(Integer feature2) {
		Feature2 = feature2;
	}
	public Integer getFeature3() {
		return Feature3;
	}
	public void setFeature3(Integer feature3) {
		Feature3 = feature3;
	}
	public Integer getFeature4() {
		return Feature4;
	}
	public void setFeature4(Integer feature4) {
		Feature4 = feature4;
	}
	public Integer getFeature5() {
		return Feature5;
	}
	public void setFeature5(Integer feature5) {
		Feature5 = feature5;
	}
	public Integer gettOrF() {
		return tOrF;
	}
	public void settOrF(Integer tOrF) {
		this.tOrF = tOrF;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
