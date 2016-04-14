package com.swu.question.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 分句类
 * 通过语言云的API对一篇文章进行分句
 * @author ltlix
 *
 */
public class Clauses {

	/**
	 * 通过语言云的API对一篇文章进行分句。
	 * @param content 文章内容
	 * @return 句子的数组
	 */
	public static String[] getClauses(String content){
		String txt = content.replace("<br/>", "").trim();
		String xmlString = HttpRequest.sendGet("http://api.ltp-cloud.com/analysis/", "api_key=n2T5b2L8XA0sMuSEJlQwZZqNxtDkdxJIEccA9Ree&text="+txt+"&pattern=all&format=xml");
		StringReader sr = new StringReader(xmlString);  
		InputSource is = new InputSource(sr);   
		  
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		  
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}    
		Document doc = null;
		try {
			doc = builder.parse(is);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        
		NodeList ele = doc.getElementsByTagName("sent");
		String[] scentence = new String[ele.getLength()];
		for(int i=0;i<ele.getLength();i++){
			scentence[i]=ele.item(i).getAttributes().getNamedItem("cont").getTextContent().toString();
		}
		return scentence;
	}
	
}
