package com.swu.question.util;

/*
 * import 
 * jacob.jar
 */

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class WordToHtml {
	private final static WordToHtml oOfficeToHtml = new WordToHtml();

	public static WordToHtml getInstance() {
		return oOfficeToHtml;
	}

	public WordToHtml() {
	}

	public boolean excueWordtoHtml(String wordPath, String htmlPath) {
		ComThread.InitSTA();
		ActiveXComponent activexcomponent = new ActiveXComponent(
				"Word.Application");
		String s2 = wordPath;
		String s3 = htmlPath;
		boolean flag = false;
		try {
			activexcomponent.setProperty("Visible", new Variant(false));
			Dispatch dispatch = activexcomponent.getProperty("Documents")
					.toDispatch();
			Dispatch dispatch1 = Dispatch.invoke(dispatch, "Open", 1,
					new Object[] { s2, new Variant(false), new Variant(true) },
					new int[1]).toDispatch();
			Dispatch.invoke(dispatch1, "SaveAs", 1, new Object[] { s3,
					new Variant(8) }, new int[1]);
			Variant variant = new Variant(false);
			Dispatch.call(dispatch1, "Close", variant);
			flag = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			activexcomponent.invoke("Quit", new Variant[0]);
			ComThread.Release();
			ComThread.quitMainSTA();
		}
		return flag;
	}
}
