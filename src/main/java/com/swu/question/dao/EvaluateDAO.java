package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Evaluate;
import com.swu.question.entity.Text;

public interface EvaluateDAO {
	public  boolean addEvaluate(Evaluate evaluate);
	public List<Integer> queryEvaluateByStuId(int stuId);
	public List<Integer> queryEvaluateByTextId(int textId);
	public List<Text> listEvaluated(int courseId);
	public List<Evaluate> listEvaluatedDownload(String courseId);
	public boolean deleteEvaluatebyStu(int textId,int stuId);
	public int countTextByCourseId(String courseId);
}
