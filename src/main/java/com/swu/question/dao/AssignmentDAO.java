package com.swu.question.dao;
import java.util.List;

import com.swu.question.entity.Assignment;


public  interface AssignmentDAO {
/**
 * 
 * @return
 *      List<Assignment>
 */
public List<Assignment> listAssignment();
/**
 * 
 * @param assignment
 */
public boolean addAssignment(Assignment assignment);
/**
 * 
 * @param teaId
 * @param pageNow
 * @return
 */
public List<Assignment> selectAssignmentByteaId(int teaId, int pageNow) ;
/**
 * 
 * @param teaId
 * @return
 */
public int countAssignmentByTeaId(Integer teaId);
/**
 * 
 * @param courseId
 * @param findAss
 * @return
 */
List<Assignment> selectAssignmentByCourseId(int courseId,String findAss);
/**
 * 
 * @param assId
 */
public void deleteAssignment(int assId);
/**
 * 
 * @param stuId
 * @return
 */
public List<Assignment> listAllAssignment(Integer stuId);
/**
 * 
 * @param assId
 * @return
 */
public Assignment queryAssignment(Integer assId);
/**
 * 
 * @param textId
 * @return
 */
public List<Assignment> queryAssignmentByTextId(Integer textId);
}
