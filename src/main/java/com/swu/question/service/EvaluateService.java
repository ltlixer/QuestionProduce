package com.swu.question.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.swu.question.entity.Evaluate;
import com.swu.question.entity.Log;
import com.swu.question.entity.Student;
import com.swu.question.entity.Text;


public interface EvaluateService {
	public  boolean addEvaluate(Evaluate evaluate);
	public  boolean addEvaluateJson(List<Map<String,String>> evaluates,String textId, Student student);
	/*public List<Evaluate> queryEvaluateByTextId(int stuId);*/
	public List<Text> listEvaluated(int courseId);
	public boolean downloadEvaluated(String[] courseIds,HttpServletResponse response, String path,
			String fileName);
	
	public boolean deleteEvaluate(int textId,int stuId);
	
	/**
	 * 下载学生做作业日志
	 * @param courseIds
	 * @param response
	 * @param path
	 * @param fileName
	 * @return
	 */
	public boolean downloadLogStu(String[] courseIds,HttpServletResponse response, String path,
			String fileName);
	/**
	 * 查询学生做作业日志
	 * @param courseIds
	 * @return
	 */
	public List<Log> queryLogStu(String[] courseIds);
	/**
	 * 下载教师布置作业日志
	 * @param courseIds
	 * @param response
	 * @param path
	 * @param fileName
	 * @return
	 */
	public boolean downloadLogTea(String[] courseIds,HttpServletResponse response, String path,
			String fileName);
	/**
	 * 查询教师布置作业日志
	 * @param courseIds
	 * @return
	 */
	public List<Log> queryLogTea(String[] courseIds);
	
	/**
	 * 评估使用
	 */
	public List<Text> listTexts(int courseId,int stuId);
	public int countListTexts(int courseId, int stuId);
	public List<Text> listTextsEvaluated(int stuId);
	public int countlistTextsEvaluated(int stuId);
	
	public int countTextByCourseId(String courseId);
}
