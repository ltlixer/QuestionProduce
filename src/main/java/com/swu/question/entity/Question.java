package com.swu.question.entity;

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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "QUESTION")
public class Question {
	@Id
	@Column(name = "QID")
	@GeneratedValue
	private Integer qId;
	@Column(name = "SENTENCE")
	private String sentence;
	@Column(name = "ANSWER", nullable = false)
	private String answer;
	@Column(name = "QUESTION", nullable = false)
	private String question;
	@Column(name = "QUESTIONTYPE", nullable = false)
	private String questionType;
	@ManyToOne
	@JoinColumn(name = "assignment_ID", referencedColumnName = "assId", nullable = false)
	private Assignment assignment;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
	private Set<Distracter> distracter;//选择题的干扰项
	
	
	public Set<Distracter> getDistracter() {
		return distracter;
	}
	public void setDistracter(Set<Distracter> distracter) {
		this.distracter = distracter;
	}
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
