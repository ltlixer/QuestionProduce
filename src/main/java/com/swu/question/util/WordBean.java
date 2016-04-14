package com.swu.question.util;

import java.util.ArrayList;
import java.util.List;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordBean {
	// 代表一个word 程序
	private ActiveXComponent MsWordApp = null;
	// 代表进行处理的word 文档
	private Dispatch document = null;

	public WordBean() {
		// Open Word if we've not done it already
		if (MsWordApp == null) {
			MsWordApp = new ActiveXComponent("Word.Application");
		}
	}

	/**
	 * @param visible
	 *            文档是否可见 true 可见 false 不可见
	 * 
	 * @return
	 */
	public void setVisible(boolean visible) {
		MsWordApp.setProperty("Visible", new Variant(visible));
		// 这一句作用相同
		// Dispatch.put(MsWordApp, "Visible", new Variant(visible));
	}

	/**
	 * 打开一个存在的word文档,并用document 引用 引用它
	 * 
	 * @param wordFilePath
	 * @param readonly
	 *            是否只读 true 只读 false 可读写 打开文档的路径path
	 */
	public void openFile(String wordFilePath, boolean readonly) {
		// Find the Documents collection object maintained by Word
		// documents表示word的所有文档窗口，（word是多文档应用程序）
		Dispatch documents = Dispatch.get(MsWordApp, "Documents").toDispatch();
		document = Dispatch.call(documents, "Open", wordFilePath,
				new Variant(true)/* 是否进行转换ConfirmConversions */,
				new Variant(readonly)/* 是否只读 */).toDispatch();
	}

	/**
	 * 读取文档中文字的内容 按段读取;
	 * 
	 * @return
	 */
	public List<String> getWordText() {
		Dispatch paragraphs = Dispatch.get(document, "Paragraphs").toDispatch(); // 所有段落
		int paragraphCount = Dispatch.get(paragraphs, "Count").getInt(); // 一共的段落数
		Dispatch paragraph = null;
		Dispatch range = null;
		String str = "";
		List<String> requestList = new ArrayList<String>();
		for (int i = 1; i <= paragraphCount; i++) {
			paragraph = Dispatch.call(paragraphs, "Item", new Variant(i))
					.toDispatch();
			range = Dispatch.get(paragraph, "Range").toDispatch();
			str = Dispatch.get(range, "Text").toString().trim();
			if (!str.equals("")) {
				requestList.add(str);
			}

		}
		return requestList;
	}

	
	/**
	 * 保存并关闭文档
	 */
	public void close() {
		Dispatch.call(document, "Close", new Variant(0));
		document = null;
		Dispatch.call(MsWordApp, "Quit");
		MsWordApp = null;
		document = null;
	}

}
