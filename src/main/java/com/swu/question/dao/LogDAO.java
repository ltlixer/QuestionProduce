package com.swu.question.dao;

import java.util.List;

import com.swu.question.entity.Log;


public interface LogDAO {
	public List<Log> queryLogs();
	public List<Log> queryLogsByAssId(int assId);
	public List<Log> queryLogsByCourseIdStu(String courseId);
	public List<Log> queryLogsByCourseIdTea(String courseId);
	public boolean deleteLogByAssId(int assId);
	public boolean addLog(Log log);
	
}
