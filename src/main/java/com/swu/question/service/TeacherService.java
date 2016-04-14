package com.swu.question.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.swu.question.entity.Teacher;

public interface TeacherService {
	/**
	 * 添加 teacher对象
	 * @param teacher
	 * @return true 成功  false 失败
	 */
	public boolean addTeacher(Teacher teacher);
	
    /**
     * 删除teacher
     * @param id
     */
    public void deleteTeacher(Integer id);
    /**
     * teacher登录
     * @param teaNum
     *          登录账号
     * @param teaPass
     *          登录密码
     * @return
     */
    public Teacher teacherLogin(String teaNum,String teaPass);
    /**
     * 注册teacher
     * @param teaNum
     *          注册账号
     * @return  
     *    true 不存在该账号 false 存在该账号  
     */
    public boolean teacherRegisterCheck(String teaNum);
    /**
     * 修改teacher密码
     * @param teaId
     * @param pswd
     * @return
     */
    public boolean teacherUpdatePssword(int teaId,String pswd);
    /**
     * 根据当前 teacher 的 id 修改 存储在当前 teacher中的其他值 ：
     * teaName  teaEmail teaMajor
     * @param teacher
     * @return
     */
    public boolean updateTeacherInfor(Teacher teacher);
    /**
     * 
     * @param teaId
     * @return
     */
    public Teacher queryTeacher(int teaId); 
    /**
     * 
     * @param teaId
     * @return
     */
  /*  public Set<Student> queryTeacherToStudent(int teaId);*/
    /**
     * 移除选择老师的学生
     * @param teaId  老师
     * @param stuId  需要移除的学生的id
     * @return
     */
    public boolean removeStudentBystuId(int teaId,int stuId);
    /**
     * 
     * @return
     */
    public List<Teacher>listTeacher();
   /* *//**
     * 
     * @return
     *//*
	public int listTeacher1();
	*//**
	 * 查询所有teacher
	 * @param pageNow 
	 * @return
	 *//*
    public List<Teacher> listTeacher(int pageNow);*/
    /**
     * 读取Excell表格 中的学生信息添加到数据库
     * @param file
     * @param savePath
     * @param teacher
     * @return
     */
    public String addStudents(MultipartFile file,String savePath,Teacher teacher);
}
