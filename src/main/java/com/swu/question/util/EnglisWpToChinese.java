package com.swu.question.util;

/*
如这样一串字符串 【实现要转移的字符把"单引号"变成"双引号"】

用java如何才能把其中的英文双引号变成中文的呢？要考虑前后引号，前面的是“，后面的是”。
返回结果：【实现要转移的字符把“单引号”变成“双引号”】
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnglisWpToChinese{
	//处理双引号
  public  String doubleQuotationMarks(String content){
      String regex = "(.*)\"(.*)\"(.*)";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(content);

      while(matcher.find()){
          content = matcher.group(1) + "“" + matcher.group(2) + "”" + matcher.group(3);
          matcher = pattern.matcher(content);
      }
      return content;
  }
}