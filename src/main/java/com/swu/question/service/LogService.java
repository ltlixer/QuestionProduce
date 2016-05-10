package com.swu.question.service;

import java.util.List;

import com.swu.question.entity.Log;

public interface LogService {
	
	public List<Log> queryStudentCostTime(int assId);
}
