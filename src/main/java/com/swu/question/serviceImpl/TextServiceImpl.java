
package com.swu.question.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.swu.question.dao.AssignmentDAO;
import com.swu.question.dao.CourseDAO;
import com.swu.question.dao.EvaluateDAO;
import com.swu.question.dao.TextDAO;
import com.swu.question.entity.Assignment;
import com.swu.question.entity.Course;
import com.swu.question.entity.NewWords;
import com.swu.question.entity.Teacher;
import com.swu.question.entity.Text;
import com.swu.question.service.TextService;
import com.swu.question.util.DeleteFile;
import com.swu.question.util.EnglisWpToChinese;
import com.swu.question.util.UploadDownloadFile;
import com.swu.question.util.WordBean;
import com.swu.question.util.WordToHtml;
/**
 * 
* @Title: TextServiceImpl.java 
* @Description: TODO(课文的服务层实现类) 
* @author yanhao  
* @date 2016年3月29日 下午12:52:03 
* @version V1.0
 */
@Service
public class TextServiceImpl implements TextService {
	@Autowired
	private TextDAO textDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private AssignmentDAO asssignmentDAO;
	@Autowired
	private EvaluateDAO evaluateDAO;
	
	@Override
	@Transactional
	public String addText(MultipartFile[] files, String savePath, Text text,
			Teacher teacher,String courseId) {
		// TODO Auto-generated method stub

		/* MultipartFile[] file12 = { files[1], files[2] }; */
		try {
			UploadDownloadFile uploadFile = new UploadDownloadFile();
			// 文件上传
			String message = uploadFile.uploadfile(files[0], savePath);
			/* String file12Name[] = uploadFile.uploadfiles(file12, savePath); */
			if (message.equals("NoFile")) {
				return "NoFile";
			} else if (message.equals("error")) {
				return "upError";
			} else {
				// word文件转为html
				System.out.println(message);
				if (message.substring(message.indexOf(".") + 1).equals("docx")
						|| message.substring(message.indexOf(".") + 1).equals(
								"doc")) {
					String wordPath = savePath + "\\" + message;
					String htmlPath = savePath + "\\"
							+ message.substring(0, message.lastIndexOf("_"))
							+ ".html";
					WordToHtml wordToHtml = WordToHtml.getInstance();
					boolean b = wordToHtml.excueWordtoHtml(wordPath, htmlPath);
					
					String testPath = savePath + "\\" + message;
					WordBean wordBean = new WordBean();
					wordBean.setVisible(false); // 是否前台打开word 程序，或者后台运行
					List<String> list = null;
					try {
						File file=new File(testPath);    
						if(!file.exists()){
							return null;
						}
						wordBean.openFile(testPath, true); // 只读
						// list 读取文档的列表内容
						list = wordBean.getWordText();
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
					wordBean.close();
					//获取文章最后一段文字
					String newWordsSc = list.get(list.size()-1);
					if(newWordsSc.startsWith("##")){
						newWordsSc = newWordsSc.substring(2, newWordsSc.length());
						newWordsSc = newWordsSc.trim();
					}
					if (b) {
						text.setTeacher(teacher);
						text.setCreateTime(new Date());
						text.setTextURL(savePath);
						text.setTextName(message);
						Course course =courseDAO.selectCourseById(Integer.parseInt(courseId));
						text.setCourse(course);
						String[] newWordsList = newWordsSc.split(" ");
						Set<NewWords> newWords = new HashSet<NewWords>();
						for(String newWord:newWordsList){
							newWords.add(new NewWords(newWord,text));
						}
						text.setNewWords(newWords);
						boolean f = textDAO.addText(text);
						if (f) {
							return "Success";
						} else {
							return "addError";
						}
					} else {
						return "changeError";
					}
				} else {
					return "NoWord";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	@Override
	@Transactional
	public String deleteText(int textId) {
		// TODO Auto-generated method stub
		try {
			//删除课文前，先判断是否布置了作业，如该课文已经有作业，不能删除
			List<Assignment> list = asssignmentDAO.queryAssignmentByTextId(textId);
			if(list.size()>0){//有作业
				return "no";
			}
			//检查是否已经有评估
			List<Integer> tids = evaluateDAO.queryEvaluateByTextId(textId);
			if(tids.size()>0){
				return "no2";
			}
			Text text = textDAO.queryText(textId);
			DeleteFile deleteFile = new DeleteFile();
			String textName = text.getTextName();
			String textPath = text.getTextURL() + "\\" + textName;
			String htmlPath = text.getTextURL() + "\\"
					+ textName.substring(0, textName.indexOf("_")) + ".html";
			String folderText = text.getTextURL() + "\\"
					+ textName.substring(0, textName.indexOf("_")) + ".files";
			deleteFile.deleteFile(textPath);
			deleteFile.delFolder(folderText);
			deleteFile.deleteFile(htmlPath);
			textDAO.deleteText(textId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	@Transactional
	public List<Text> queryTextByCourseId(String courseId, int pageNow,
			String findText) {
			// TODO Auto-generated method stub
			return textDAO.listTextByCourseIdDividePage(courseId, pageNow, findText);
	}
/**
 * 根据 课文标题查找 指定老师发布的课文
 */
	@Override
	@Transactional
	public int countTextByCourseId(String courseId, String findText) {
		// TODO Auto-generated method stub
			return textDAO.countTextByCourseId(courseId, findText);
	}

	@Override
	public String downloadText(HttpServletResponse response, String path,
			String fileName) {
		// TODO Auto-generated method stub
		UploadDownloadFile uploadFile = new UploadDownloadFile();
		try {
			return uploadFile.download(response, path, fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "下载失败";
	}

	/**
	 * 读取 word文档
	 */
	@SuppressWarnings("null")
	@Override
	public List<String> readWordText(int textId) {
		// TODO Auto-generated method stub
		Text text = textDAO.queryText(textId);
		String testPath = text.getTextURL() + "\\" + text.getTextName();
		WordBean wordBean = new WordBean();
		wordBean.setVisible(false); // 是否前台打开word 程序，或者后台运行
		List<String> list = null;
		try {
			File file=new File(testPath);    
			if(!file.exists()){
				return null;
			}
			wordBean.openFile(testPath, true); // 只读
			// list 读取文档的列表内容
			list = wordBean.getWordText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		wordBean.close();
		List<String> relist = new ArrayList<String>();
		EnglisWpToChinese etc = new EnglisWpToChinese();
		for(int i = 0;list!=null&&i<list.size();i++){
			if(list.get(i).indexOf("##")==-1){
				String str = etc.doubleQuotationMarks(list.get(i));
				relist.add(str);
			}
		}
		
		return relist;
	}

	@Override
	@Transactional
	public List<Text> queryTextByTeas(int teaId,int pageNow) {
		// TODO Auto-generated method stub
		return textDAO.queryTextByTeas(teaId,pageNow);
	}
	@Override
	@Transactional
	public int countqueryTextByTeas(int teaId){
		return textDAO.countqueryTextByTeas(teaId);
	}
	@Override
	@Transactional
	public Text queryTextByTextId(int textId) {
		// TODO Auto-generated method stub
		return textDAO.queryText(textId);
	}

	
	

}
