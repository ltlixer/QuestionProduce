package com.swu.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 问题类型（选择、填空、问答）
 * @author ltlix
 *
 */
@Entity
@Table(name = "QUESTIONTYPE")
public class QuestionType {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "QUESTIONTYPE", nullable = false)
	private String questionType; //问题类型

	@Column(name = "QUESTIONTYPENAME", nullable = false)
	private String questionTypeName; //问题类型名称
	
	public QuestionType(){}
	public QuestionType(String questionType,String questionTypeName) {
		this.questionType = questionType;
		this.questionTypeName = questionTypeName;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	

}
