package com.swu.question.dto;

public class StudentAnswerAnalysis {
	private int questionId;
	private String questionName;
	private String questionType;
	private String studentName;
	private String studentGrade;
	private String studentAnswer;
	private String systemAnswer;
	private String tORf;
	
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	public String getSystemAnswer() {
		return systemAnswer;
	}
	public void setSystemAnswer(String systemAnswer) {
		this.systemAnswer = systemAnswer;
	}
	public String gettORf() {
		return tORf;
	}
	public void settORf(String tORf) {
		this.tORf = tORf;
	}
	
	
}
