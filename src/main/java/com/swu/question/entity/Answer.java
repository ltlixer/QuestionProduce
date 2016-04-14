package com.swu.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWER")
public class Answer {
	@Id
	@Column(name = "ASSWERId")
	@GeneratedValue
	private Integer asswerId;
	@Column(name = "ANSWER")
	private String answer;
	@Column(name = "TORF")
	private String tOrF;
	@Column(name = "SIMILARITY")
	private String similarity;
	@ManyToOne
	@JoinColumn(name = "Q_ID", referencedColumnName = "qId", nullable = false)
	private Question question;
	@ManyToOne
	@JoinColumn(name = "SD_ID", referencedColumnName = "saId", nullable = false)
	private ScoreAssignment scoreAssignment;
	public Integer getAsswerId() {
		return asswerId;
	}
	public void setAsswerId(Integer asswerId) {
		this.asswerId = asswerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getSimilarity() {
		return similarity;
	}
	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public ScoreAssignment getScoreAssignment() {
		return scoreAssignment;
	}
	public void setScoreAssignment(ScoreAssignment scoreAssignment) {
		this.scoreAssignment = scoreAssignment;
	}
	public String gettOrF() {
		return tOrF;
	}
	public void settOrF(String tOrF) {
		this.tOrF = tOrF;
	}
	
}
