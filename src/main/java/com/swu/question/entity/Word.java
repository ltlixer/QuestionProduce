package com.swu.question.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 字库表
 * @author ltlix
 *
 */
@Entity
@Table(name = "WORD")
public class Word {	
	@Id
	@Column(name = "WORDID")
	@GeneratedValue
	private int id;
	@Column(name = "WORD",nullable=false)
	private String word;
	@Column(name = "BS")
	private String bs;	//部首
	@Column(name = "JG")
	private String jg;	//结构
	@Column(name = "BH")
	private String bh;	//笔画
	@Column(name = "PY")
	private String py;	//拼音
	@Column(name = "HSK")
	private String hsk;	//拼音
//	@Column(name = "FREQUENCY")
//	private String frequency;	//频率
//	@Column(name = "SD")
//	private String sd;	//声调
//	@Column(name = "SP")
//	private String sp;	//声旁
	

//	public String getSd() {
//		return sd;
//	}
//	public void setSd(String sd) {
//		this.sd = sd;
//	}
//	public String getSp() {
//		return sp;
//	}
//	public void setSp(String sp) {
//		this.sp = sp;
//	}
//	public String getFrequency() {
//		return frequency;
//	}
//	public void setFrequency(String frequency) {
//		this.frequency = frequency;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getPy() {
		return py;
	}
	public void setPy(String py) {
		this.py = py;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getHsk() {
		return hsk;
	}
	public void setHsk(String hsk) {
		this.hsk = hsk;
	}
}
