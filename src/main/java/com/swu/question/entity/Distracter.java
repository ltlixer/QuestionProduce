package com.swu.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 选择题问题的干扰选项
 * @author ltlix
 *
 */
@Entity
@Table(name = "DISTRACTER")
public class Distracter {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "DISTRACTER", nullable = false)
	private String distracter; //干扰项
	
	@ManyToOne
	@JoinColumn(name = "Q_ID", referencedColumnName = "qId", nullable = false)
	private Question question;
	
	public Distracter(){}
	public Distracter(String distracter,Question question) {
		this.distracter = distracter;
		this.question = question;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDistracter() {
		return distracter;
	}
	public void setDistracter(String distracter) {
		this.distracter = distracter;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
