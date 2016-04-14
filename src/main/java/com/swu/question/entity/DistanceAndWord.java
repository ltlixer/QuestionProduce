package com.swu.question.entity;


public class DistanceAndWord implements Comparable<DistanceAndWord>{
	private Integer distance;
	private Word word;
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public int compareTo(DistanceAndWord o) {
		// TODO Auto-generated method stub
		return this.getDistance().compareTo(o.getDistance());	
		}
	

	
}
