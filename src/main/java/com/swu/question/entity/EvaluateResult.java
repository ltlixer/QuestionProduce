package com.swu.question.entity;

public class EvaluateResult {
	private String courseName;
	private String teaName;
	private int countText;
	private int countEvaluate;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getCountText() {
		return countText;
	}
	public void setCountText(int countText) {
		this.countText = countText;
	}
	public int getCountEvaluate() {
		return countEvaluate;
	}
	public void setCountEvaluate(int countEvaluate) {
		this.countEvaluate = countEvaluate;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	
}
