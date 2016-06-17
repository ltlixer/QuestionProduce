package com.swu.question.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.swu.question.dto.StudentAnswerAnalysis;
import com.swu.question.entity.Evaluate;
import com.swu.question.entity.Log;
import com.swu.question.entity.Student;

public class ExcelBean {
	private static ActiveXComponent xl = null; // Excel对象(防止打开多个)
	private static Dispatch workbooks = null; // 工作簿对象
	private Dispatch workbook = null; // 具体工作簿
	@SuppressWarnings("unused")
	private Dispatch sheets = null;// 获得sheets集合对象
	private Dispatch currentSheet = null;// 当前sheet

	public ExcelBean() {
		initComponents();
		if (xl == null) {
			xl = new ActiveXComponent("Excel.Application"); // Excel对象
		}
	}

	/**
	 * @param visible
	 *            文档是否可见 true 可见 false 不可见
	 * 
	 * @return
	 */
	private void setVisible(boolean visible) {
		xl.setProperty("Visible", new Variant(visible));
		// 这一句作用相同
		// Dispatch.put(MsWordApp, "Visible", new Variant(visible));
	}

	/**
	 * 打开excel文件
	 * 
	 * @param filepath
	 *            文件路径名称
	 * @param readonly
	 *            是否只读方式打开 true 只读 false可读写
	 */
	private void openExcel(String filepath, boolean readonly) {
		try {
			if (workbooks == null)
				workbooks = xl.getProperty("Workbooks").toDispatch(); // 工作簿对象
			workbook = Dispatch.invoke(
					// 打开具体工作簿
					workbooks,
					"Open",
					Dispatch.Method,
					new Object[] { filepath, new Variant(false),
							new Variant(readonly) },// 是否以只读方式打开
					new int[1]).toDispatch();
		} catch (Exception e) {
			e.printStackTrace();
			releaseSource();
		}
	}

	/**
	 * 关闭 文档 应用
	 */
	private void closeExcel() {
		// Close the document without saving changes
		// 0 = wdDoNotSaveChanges
		// -1 = wdSaveChanges
		// -2 = wdPromptToSaveChanges
		Dispatch.call(workbook, "Close", new Variant(0));
		// 关闭应用
		Dispatch.call(xl, "Quit");
		xl = null;
		workbook = null;
	}

	/**
	 * 释放资源
	 */
	private static void releaseSource() {
		if (xl != null) {
			xl.invoke("Quit", new Variant[] {});
			xl = null;
		}
		workbooks = null;
		ComThread.Release();
		System.gc();
	}

	/**
	 * 得到当前sheet
	 * 
	 * @return
	 */
	private Dispatch getCurrentSheet() {
		currentSheet = Dispatch.get(workbook, "ActiveSheet").toDispatch();
		return currentSheet;
	}

	/**
	 * 获取最大行数
	 * 
	 * @return
	 */
	private int getRowCount() {
		currentSheet = this.getCurrentSheet();
		Dispatch UsedRange = Dispatch.get(currentSheet, "UsedRange")
				.toDispatch();
		Dispatch rows = Dispatch.get(UsedRange, "Rows").toDispatch();
		int num = Dispatch.get(rows, "count").getInt();
		return num;
	}

	/**
	 * 获取最大列数
	 * 
	 * @return
	 */
	private int getColumnCount() {
		currentSheet = this.getCurrentSheet();
		Dispatch UsedRange = Dispatch.get(currentSheet, "UsedRange")
				.toDispatch();
		Dispatch Columns = Dispatch.get(UsedRange, "Columns").toDispatch();
		int num = Dispatch.get(Columns, "count").getInt();
		return num;
	}

	/**
	 * 单元格读取值
	 * 
	 * @param position
	 *            单元格位置，如： C1
	 * @param sheet
	 * @return
	 */
	private Variant getValue(String position, Dispatch sheet) {
		Dispatch cell = Dispatch.invoke(sheet, "Range", Dispatch.Get,
				new Object[] { position }, new int[1]).toDispatch();
		Variant value = Dispatch.get(cell, "Value");
		return value;
	}
	/**
	 * 单元格写入值
	 * 
	 * @param sheet
	 *            被操作的sheet
	 * @param position
	 *            单元格位置，如：C1
	 * @param value
	 */
	public void setValue(Dispatch sheet, String position,
			String value) {
		Dispatch cell = Dispatch.invoke(sheet, "Range", Dispatch.Get,
				new Object[] { position }, new int[1]).toDispatch();
		Dispatch.put(cell, "Value", value);
	}
	private void initComponents() {
		workbooks = null;
		workbook = null;
		currentSheet = null;
		sheets = null;
	}

	/**
	 * 工作簿另存为
	 * 
	 * @param filePath
	 *            另存为的路径
	 */
	
	public void saveFileAs(String filePath) {  
        Dispatch.call(workbook, "SaveAs", filePath);  
    } 
	/**
	 * 保存当前更改文件
	 */
	  public void save() {  
	        Dispatch.call(workbook, "Save");  
	    }
	public List<Student> getStudentNumAndGrade(String path) {
		List<Student> list = new ArrayList<Student>();
		ExcelBean excellBean = new ExcelBean();
		try {
			excellBean.setVisible(false);
			excellBean.openExcel(path, true);// 只读
			char stuidcolum = 'A';
			int stuidrow = 1;
			char gradecolum = 'A';
			char namecolum = 'A';
			boolean findStuid = false;
			boolean findgrade = false;
			boolean findname = false;
			Dispatch sheet = excellBean.getCurrentSheet();
			// 查找学号 成绩 所在的列
			for (int row = 1; row <= excellBean.getRowCount(); row++) {
				for (int colum = 0; colum < excellBean.getColumnCount(); colum++) {
					char col = 'A';
					col = (char) (col + colum);
					String cellName = col + "" + row;
					Variant variant = excellBean.getValue(cellName, sheet);
					String value = variant.toString().trim();
					if (value.equals("学号")) {
						stuidcolum = col;
						stuidrow = row;
						System.out.println(stuidcolum + "" + stuidrow);
						findStuid = true;
					}
					if (value.equals("成绩")) {
						gradecolum = col;
						findgrade = true;
					}
					if (value.equals("姓名")) {
						namecolum = col;
						findname = true;
					}
					if (findStuid && findgrade && findname)
						break;

				}
				if (findStuid && findgrade && findname)
					break;
			}

			if (findStuid && findgrade && findname) {
				int row = excellBean.getRowCount();
				String stuidCellName = "A1";
				String gradeCellName = "A1";
				String nameCellName = "A1";
				for (int i = stuidrow + 1; i <= row; i++) {
					stuidCellName = stuidcolum + "" + i;
					gradeCellName = gradecolum + "" + i;
					nameCellName = namecolum + "" + i;
					Variant variantStuid = excellBean.getValue(stuidCellName,
							sheet);
					Variant variantGrade = excellBean.getValue(gradeCellName,
							sheet);
					Variant variantName = excellBean.getValue(nameCellName,
							sheet);
					Student student = new Student();
					String stunum = variantStuid.toString();
					if(stunum.lastIndexOf(".")!=-1){
						stunum = stunum.substring(0,stunum.lastIndexOf("."));
					}
					student.setStuNum(stunum);
					student.setStuPassword(new ChineseToEnglish()
							.getPingYin(variantName.toString()));
					student.setStuName(variantName.toString());
					student.setGrade(Double.parseDouble(variantGrade.toString()));
					list.add(student);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			excellBean.closeExcel();
		}
		return list;
	}

	public String setValues(String path,String filename,List<Evaluate> list){
			ExcelBean excellBean = new ExcelBean();
			excellBean.setVisible(false);//可见
			excellBean.openExcel(path+"/"+filename,false);//可读写
			Dispatch sheet = excellBean.getCurrentSheet();
			int row =2;
			Evaluate e = new Evaluate();
			for(int i=0;list!=null&&i<list.size();i++){
				e = list.get(i);
				String edesc = "";
				String eTorF ="";
				String stuName="";
				boolean isTwo = false;
				if(i+1<list.size()&&(e.getQuestion().equals(list.get(i+1).getQuestion()))
						&&!(e.getStudent().getStuId().equals(list.get(i+1).getStudent().getStuId()))){
					edesc = list.get(i+1).getDescription();
					eTorF = list.get(i+1).gettOrF()+"";
					stuName = list.get(i+1).getStudent().getStuName();
					i++;
					isTwo = true;
				}
				if(i+1<list.size()&&(e.getQuestion().equals(list.get(i+1).getQuestion()))
						&&(e.getStudent().getStuId().equals(list.get(i+1).getStudent().getStuId()))){
					continue;
				}
				excellBean.setValue(sheet, "A"+row,e.getText().getTextTitle());
				excellBean.setValue(sheet, "B"+row,e.getSentenceId()+"");
				excellBean.setValue(sheet, "C"+row,e.getSentece());
				excellBean.setValue(sheet, "D"+row,e.getQuestion());
				excellBean.setValue(sheet, "E"+row,e.gettOrF()+"");
				excellBean.setValue(sheet, "F"+row,e.getDescription());
				excellBean.setValue(sheet, "G"+row,e.getStudent().getStuName());
				if(isTwo){
					excellBean.setValue(sheet, "H"+row,eTorF);
					excellBean.setValue(sheet, "I"+row,edesc);
					excellBean.setValue(sheet, "J"+row,stuName);
				}
				excellBean.setValue(sheet, "K"+row,e.getAnswer());
				excellBean.setValue(sheet, "L"+row,e.getFeature1()+"");
				excellBean.setValue(sheet, "M"+row,e.getFeature2()+"");
				excellBean.setValue(sheet, "N"+row,e.getFeature3()+"");
				excellBean.setValue(sheet, "O"+row,e.getFeature4()+"");
				excellBean.setValue(sheet, "P"+row,e.getFeature5()+"");
				row++;
			}
			String fileName = UUID.randomUUID().toString()+"-"+filename;
			excellBean.saveFileAs(path+"/"+fileName);;
			excellBean.closeExcel();
			return fileName;
		}
	
	public String setLogs(String path,String filename,List<Log> list){
		ExcelBean excellBean = new ExcelBean();
		excellBean.setVisible(false);//可见
		excellBean.openExcel(path+"/"+filename,false);//可读写
		Dispatch sheet = excellBean.getCurrentSheet();
		int row =2;
		Log log = new Log();
		 SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		for(int i=0;list!=null&&i<list.size();i++){
			log = list.get(i);
			excellBean.setValue(sheet, "A"+row,log.getAssignment().getText().getTextTitle());
			excellBean.setValue(sheet, "B"+row,log.getAssignment().getAssId()+"");
			excellBean.setValue(sheet, "C"+row,log.getQuestionType());
			excellBean.setValue(sheet, "D"+row,sdf.format(log.getStartTime()));
			excellBean.setValue(sheet, "E"+row,sdf.format(log.getEndTime()));
			excellBean.setValue(sheet, "F"+row,log.getUser());
			row++;
		}
		String fileName = UUID.randomUUID().toString()+"-"+filename;
		excellBean.saveFileAs(path+"/"+fileName);;
		excellBean.closeExcel();
		return fileName;
	}
	public String setStudentAnswerAnalysis(String path,String assName,String filename,List<StudentAnswerAnalysis> list){
		ExcelBean excellBean = new ExcelBean();
		excellBean.setVisible(false);//可见
		excellBean.openExcel(path+"/"+filename,false);//可读写
		Dispatch sheet = excellBean.getCurrentSheet();
		int row =2;
		StudentAnswerAnalysis studentAnswerAnalysis = new StudentAnswerAnalysis();
		for(int i=0;list!=null&&i<list.size();i++){
			studentAnswerAnalysis = list.get(i);
			excellBean.setValue(sheet, "A"+row,studentAnswerAnalysis.getQuestionId()+"");
			excellBean.setValue(sheet, "B"+row,studentAnswerAnalysis.getQuestionName());
			excellBean.setValue(sheet, "C"+row,studentAnswerAnalysis.getQuestionType());
			excellBean.setValue(sheet, "D"+row,studentAnswerAnalysis.getStudentName());
			excellBean.setValue(sheet, "E"+row,studentAnswerAnalysis.getStudentGrade());
			excellBean.setValue(sheet, "F"+row,studentAnswerAnalysis.getStudentAnswer());
			excellBean.setValue(sheet, "G"+row,studentAnswerAnalysis.getSystemAnswer());
			excellBean.setValue(sheet, "H"+row,studentAnswerAnalysis.gettORf());
			row++;
		}
		String fileName = assName+"-"+filename;
		excellBean.saveFileAs(path+"/"+fileName);;
		excellBean.closeExcel();
		return fileName;
	}
	

	
}
