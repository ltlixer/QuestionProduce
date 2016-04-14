package com.swu.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文章的生字
 * @author ltlix
 *
 */
@Entity
@Table(name = "NEWWORDS")
public class NewWords {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	@Column(name = "WORD", nullable = false)
	private String word;
	@ManyToOne
	@JoinColumn(name = "TEXT_ID", referencedColumnName = "textId", nullable = false)
	private Text text;
	
	public NewWords(){}
	public NewWords(String word, Text text) {
		this.word = word;
		this.text = text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}

}
