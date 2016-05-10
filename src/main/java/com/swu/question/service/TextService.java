package com.swu.question.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.swu.question.entity.Teacher;
import com.swu.question.entity.Text;

public interface TextService {
/**
 * 根据 text课文的 Id  查询课文
 * @param textId
 * @return
 */
public Text queryTextByTextId(int textId);
/**
 * 添加课文 
 * @param files 上传的课文文件{后期可扩展为上传多个文件MultipartFile[]}
 * @param savePath 上传课文保存的路径
 * @param text 课文实体
 * @param teacher 上传教师
 * @return
 */
public String addText(MultipartFile[] files,String savePath,Text text,Teacher teacher,String courseId);
/**
 * 根据 课文Text的Id删除 课文
 * @param textId
 * @return
 */
public String deleteText(int textId);
/**
 * 根据老师的id查询课文
 * @param teaId
 * @return
 */
public List<Text> queryTextByTeas(int teaId,int pageNow);
public int countqueryTextByTeas(int teaId);
/**
 * 根据 课文标题 在所选教师发布课文范围内 查询课文  
 * @param teachers
 * @param pageNow   分页参数
 * @param findText
 * @return
 */
public List<Text> queryTextByCourseId(String courseId,int pageNow,String findText);
public List<Text> queryTextByCourseId(int courseId);
/**
 *  为  queryTextByTeas(teachers,pageNow,findText) 分页做准备   查询做大的数据条数
 * @param teachers
 * @param findText
 * @return
 */
public int countTextByCourseId(String courseId,String findText);
/**
 * 下载文件 
 * @param response
 * @param path 文件位置
 * @param fileName 文件名称
 * @return
 */
public String downloadText(HttpServletResponse response, String path,String fileName);
/**
 * 读取 课文内容 
 * @param textId 课文ID
 * @return
 */
public List<String> readWordText(int textId);


}
