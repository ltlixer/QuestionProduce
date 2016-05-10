package com.swu.question.service;

import java.util.List;
import java.util.Map;

import com.swu.question.entity.Assignment;
import com.swu.question.entity.Teacher;

public interface AssignmentService {
/**
* 查询所有的作业
* @return
 */
public List<Assignment> listAssignment();
/**
 * 增添作业
 * @param assignment
 * @return
 */
public boolean addAssignment(Assignment assignment);
/**
 * 
 * @param contents
 * @param teacher
 * @param ass
 * @return
 */
public boolean addAssignment(List<Map<String,String>> contents,Teacher teacher,List<Map<String,String>> ass,List<Map<String,String>> log);
/**
 * 
 * @param assId
 * @return
 */
public boolean deleteAssignment(int assId);
/**
 * 
 * @param teaId
 * @param pageNow
 * @return
 */
public List<Assignment> selectAssignmentByteaId(int teaId, int pageNow);
/**
 *  根据作业的Id查询作业
 * @param assId
 * @return
 */
public Assignment getAssignment(Integer assId);

/**
 * 查询选择此老师的学生完成的作业
 * @param integer
 * @return 返回一个ScoreAssignment 的List
 */
public int countAssignmentByTeaId(Integer teaId);
/**
 * 查询学生所有作业
 * @param stuId
 * @return
 */
public List<Assignment> listAllAssignment(Integer stuId);
/**
 * 查询学生所有未完成作业
 * @param stuId
 * @return
 */
public List<Assignment> listAllUndoneAssignment(int stuId);
/**
 * 根据作业题目模糊查询学生作业
 * @param teachers
 * @param stuId
 * @param findAss
 * @return
 */
List<Assignment> listAllAssignment(int courseId, int stuId,String findAss);
/**
 * 查询某篇课文下的所有作业
 * @param textId
 * @return
 */
List<Assignment> queryAssignmentByTextId(int textId);
/**
 * 查询某篇课文下的未完成作业
 * @param stuId
 * @param textId
 * @return
 */
List<Assignment> queryTextUndoneAssignment(int stuId,int textId);
}
