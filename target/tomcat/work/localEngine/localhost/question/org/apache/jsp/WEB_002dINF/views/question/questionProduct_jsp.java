package org.apache.jsp.WEB_002dINF.views.question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class questionProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/views/question/../com/easyui.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("    <!-- 使用easyUI 引入包 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"></script>");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<TITLE>Student Register</TITLE>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" media=\"screen\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f7(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f8(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>问题产生</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//处理问题类型\r\n");
      out.write("\tvar multiplechoice = \"\";\r\n");
      out.write("\tvar factoid = \"\";\r\n");
      out.write("\tvar deeper = \"\";\r\n");
      out.write("\tvar original = \"\";\r\n");
      out.write("\tvar multiplechoiceStartTime=\"\";\r\n");
      out.write("\tvar multiplechoiceEndTime=\"\";\r\n");
      out.write("\tvar factoidStartTime=\"\";\r\n");
      out.write("\tvar factoidEndTime=\"\";\r\n");
      out.write("\tvar deeperStartTime=\"\";\r\n");
      out.write("\tvar deeperEndTime=\"\";\r\n");
      out.write("\tvar originalStartTime=\"\";\r\n");
      out.write("\tvar originalEndTime=\"\";\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$(\"#multiplechoiceShowQuestion\").hide();\r\n");
      out.write("\t\t$(\"#factoidShowQuestion\").hide();\r\n");
      out.write("\t\t$(\"#deeperShowQuestion\").hide();\r\n");
      out.write("\t\t$(\"#originalShowQuestion\").hide();\r\n");
      out.write("\t\t$(\"#multiplechoiceNextId\").hide();\r\n");
      out.write("\t\t$(\"#factoidNextId\").hide();\r\n");
      out.write("\t\t$(\"#deeperNextId\").hide();\r\n");
      out.write("\t\t$(\"#submitClick\").hide();\r\n");
      out.write("\t\tvar type = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${types}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tconsole.log(type);\r\n");
      out.write("\t\tvar types = type.split(\"-\");//factohibernate.cfg.xmlid deeper original\r\n");
      out.write("\t\tfor (var i = 0; i < types.length; i++) {\r\n");
      out.write("\t\t\tif (types[i] == \"multiplechoice\") {\r\n");
      out.write("\t\t\t\tmultiplechoice = \"multiplechoice\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (types[i] == \"factoid\") {\r\n");
      out.write("\t\t\t\tfactoid = \"factoid\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (types[i] == \"deeper\") {\r\n");
      out.write("\t\t\t\tdeeper = \"deeper\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (types[i] == \"original\") {\r\n");
      out.write("\t\t\t\toriginal = \"original\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//控制初始显示的数据\r\n");
      out.write("\t\tif (multiplechoice != \"\") {\r\n");
      out.write("\t\t\tshowMultiplechoice();\r\n");
      out.write("\t\t\tmultiplechoiceStartTime=new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t} else if (factoid != \"\") {\r\n");
      out.write("\t\t\tshowFactoid();\r\n");
      out.write("\t\t\t factoidStartTime=new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t} else if (deeper != \"\") {\r\n");
      out.write("\t\t\tdeeperStartTime=new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowDeeper();\r\n");
      out.write("\t\t} else if (original != \"\") {\r\n");
      out.write("\t\t\toriginalStartTime=new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowOriginal();\r\n");
      out.write("\t\t\t$('#loading').hide();\r\n");
      out.write("\t\t\t$('#infor').html('请添加问题！点击【发布作业】进行作业布置');\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("\tfunction multiplechoiceNext() {\r\n");
      out.write("\t\tmultiplechoiceEndTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\tif (factoid != \"\") {\r\n");
      out.write("\t\t\tfactoidStartTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowFactoid();\r\n");
      out.write("\t\t} else if (deeper != \"\") {\r\n");
      out.write("\t\t\tdeeperStartTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowDeeper();\r\n");
      out.write("\t\t} else if (original != \"\") {\r\n");
      out.write("\t\t\toriginalStartTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowOriginal();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction factoidNext() {\r\n");
      out.write("\t\tfactoidEndTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\tif (deeper != \"\") {\r\n");
      out.write("\t\t\tdeeperStartTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowDeeper();\r\n");
      out.write("\t\t} else if (original != \"\") {\r\n");
      out.write("\t\t\toriginalStartTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowOriginal();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deeperNext() {\r\n");
      out.write("\t\tdeeperEndTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\tif (original != \"\") {\r\n");
      out.write("\t\t\toriginalStartTime=new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t\tshowOriginal();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction showMultiplechoice() {\r\n");
      out.write("\t\t$(\"#multiplechoiceShowQuestion\").show();\r\n");
      out.write("\t\tif (factoid != \"\" || deeper != \"\" || original != \"\") {\r\n");
      out.write("\t\t\t$(\"#multiplechoiceNextId\").show();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#submitClick\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction showFactoid() {\r\n");
      out.write("\t\t$(\"#factoidShowQuestion\").show();\r\n");
      out.write("\t\tif (deeper != \"\" || original != \"\") {\r\n");
      out.write("\t\t\t$(\"#factoidNextId\").show();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#submitClick\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction showDeeper() {\r\n");
      out.write("\t\t$(\"#deeperShowQuestion\").show();\r\n");
      out.write("\t\tif (original != \"\") {\r\n");
      out.write("\t\t\t$(\"#deeperNextId\").show();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#submitClick\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction showOriginal(sec) {\r\n");
      out.write("\t\t$(\"#originalShowQuestion\").show();\r\n");
      out.write("\t\t$(\"#submitClick\").show();\r\n");
      out.write("\t}\r\n");
      out.write("\t/* 处理问题类型结束 */\r\n");
      out.write("\t\r\n");
      out.write("\t/* 产生问题开始 */\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t/*调用问题产生的算法 产生问题 开始*/\r\n");
      out.write("\t\tvar contentText = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${content}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar content = [];\r\n");
      out.write("\t\tcontent[0] = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tittle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tcontent[1] = contentText;\r\n");
      out.write("\t\tif(multiplechoice != \"\"){\r\n");
      out.write("\t\t\tpasteQuestion();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(factoid !=\"\"||deeper!=\"\"){\r\n");
      out.write("\t\t\tanalyze(content);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t/*调用问题产生的算法 产生问题 结束*/\r\n");
      out.write("\t});\r\n");
      out.write("\t/* 产生问题结束 */\r\n");
      out.write("\t\r\n");
      out.write("\t/* 发布作业 */\r\n");
      out.write("\tfunction linkText() {\r\n");
      out.write("\t\tlocation.href = \"/question/text/queryText/1\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addQuestion(ck) {\r\n");
      out.write("\t\tif(originalStartTime!=\"\"){\r\n");
      out.write("\t\t\toriginalEndTime=new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t}else if(deeperStartTime!=\"\"){\r\n");
      out.write("\t\t\tdeeperEndTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t}else if(factoidStartTime !=\"\"){\r\n");
      out.write("\t\t\tfactoidEndTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t}else if(multiplechoiceStartTime !=\"\"){\r\n");
      out.write("\t\t\tmultiplechoiceEndTime = new Date().format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar str3 = \"[{'multiplechoiceStartTime':'\" + multiplechoiceStartTime + \"','multiplechoiceEndTime':'\" + multiplechoiceEndTime\r\n");
      out.write("\t\t+ \"','factoidStartTime':'\" + factoidStartTime + \"','factoidEndTime':'\" + factoidEndTime \r\n");
      out.write("\t\t+ \"','deeperStartTime':'\" + deeperStartTime + \"','deeperEndTime':'\" + deeperEndTime \r\n");
      out.write("\t\t+ \"','originalStartTime':'\" + originalStartTime + \"','originalEndTime':'\" + originalEndTime+ \"'}]\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(!add1(ck)){\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar cks = document.getElementsByClassName(ck);\r\n");
      out.write("\t\tvar checkId = 0;\r\n");
      out.write("\t\tvar count = 0;\r\n");
      out.write("\t\tvar textId = $(\"input[name='textId']\").val();\r\n");
      out.write("\t\tvar assName = $(\"input[name='assName']\").val();\r\n");
      out.write("\t\tif(assName==null||assName==\"\"){\r\n");
      out.write("\t\t\t$.messager.alert('提示', '你未添加作业标题');\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar assTime = $(\"select[name='assTime']\").val();\r\n");
      out.write("\t\tvar startDate = $(\"input[name='startDate']\").val();\r\n");
      out.write("\t\tvar str1 = \"[{'textId':'\" + textId + \"','assTime':'\" + assTime\r\n");
      out.write("\t\t\t+ \"','startDate':'\" + startDate + \"','assName':'\" + assName + \"'}]\";\r\n");
      out.write("\t\tvar str2 = \"\";\r\n");
      out.write("\t\tstr2 = \"[\";\r\n");
      out.write("\t\tfor (var i = 0; i < cks.length; i++) {\r\n");
      out.write("\t\t\tif(cks[i].checked){\r\n");
      out.write("\t\t\t\tif (cks[i].getAttribute(\"name\")==\"multiplechoice\") {\r\n");
      out.write("\t\t\t\t\tcount++;\r\n");
      out.write("\t\t\t\t\tvar sentence = $(\"td#sentence\" + cks[i].value).text();\r\n");
      out.write("\t\t\t\t\tvar question = $(\"td#question\" + cks[i].value).text();\r\n");
      out.write("\t\t\t\t\tvar answer = $(\"td#answer\" + cks[i].value).text();\r\n");
      out.write("\t\t\t\t\t/* alert(sentence+\":\"+question+\":\"+answer+\":\"+label); */\r\n");
      out.write("\t\t\t\t\tvar disp = document.getElementsByName(\"multiplechoice\"+i);\r\n");
      out.write("\t\t\t\t\tif (count == 1) {\r\n");
      out.write("\t\t\t\t\t\tstr2 += \"{'sentence':'\" + sentence + \"','question':'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ question + \"','answer':'\" + answer\r\n");
      out.write("\t\t\t\t\t\t\t\t+  \"','questiontype':'选择题','distracter':[\";\r\n");
      out.write("\t\t\t\t\t\tfor(var n = 0; n < disp.length; n++){\r\n");
      out.write("\t\t\t\t\t\t\tif(n==0)\r\n");
      out.write("\t\t\t\t\t\t\t\tstr2 += \"'\"+disp[n].value + \"'\";\r\n");
      out.write("\t\t\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\t\t\tstr2 += \",'\"+disp[n].value + \"'\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tstr2 += \"]}\";\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tstr2 += \",{'sentence':'\" + sentence + \"','question':'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ question + \"','answer':'\" + answer\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"','questiontype':'multiplechoice','distracter':[\";\r\n");
      out.write("\t\t\t\t\t\tfor(var n = 0; n < disp.length; n++){\r\n");
      out.write("\t\t\t\t\t\t\tif(n==0)\r\n");
      out.write("\t\t\t\t\t\t\t\tstr2 += \"'\"+disp[n].value + \"'\";\r\n");
      out.write("\t\t\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\t\t\tstr2 += \",'\"+disp[n].value + \"'\";\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tstr2 += \"]}\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tcount++;\r\n");
      out.write("\t\t\t\t\tvar sentence = $(\"td#sentence\" + cks[i].value).text();\r\n");
      out.write("\t\t\t\t\tvar question = $(\r\n");
      out.write("\t\t\t\t\t\t\t\"textarea.question[name='\" + cks[i].value + \"']\").val();\r\n");
      out.write("\t\t\t\t\tvar answer = $(\"textarea.answer[name='\" + cks[i].value + \"']\")\r\n");
      out.write("\t\t\t\t\t\t\t.val();\r\n");
      out.write("\t\t\t\t\tvar label = $(\"td#label\" + cks[i].value).text();\r\n");
      out.write("\t\t\t\t\t/* alert(sentence+\":\"+question+\":\"+answer+\":\"+label); */\r\n");
      out.write("\t\t\t\t\tif (count == 1) {\r\n");
      out.write("\t\t\t\t\t\tstr2 += \"{'sentence':'\" + sentence + \"','question':'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ question + \"','answer':'\" + answer\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"','questiontype':'\" + label + \"'}\";\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tstr2 += \",{'sentence':'\" + sentence + \"','question':'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ question + \"','answer':'\" + answer\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"','questiontype':'\" + label + \"'}\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tstr2 += \"]\";\r\n");
      out.write("\t\tconsole.log(str1+str2+str3);\r\n");
      out.write("\t\tvar json = {};\r\n");
      out.write("\t\tjson.content = eval(\"(\" + str2 + \")\");//转换为json对象 \r\n");
      out.write("\t\tjson.ass = eval(\"(\" + str1 + \")\");\r\n");
      out.write("\t\tjson.log= eval(\"(\" + str3 + \")\");\r\n");
      out.write("\t\tvar post = {\r\n");
      out.write("\t\t\tdata : JSON.stringify(json)\r\n");
      out.write("\t\t};//JSON.stringify(json)把json转化成字符串\r\n");
      out.write("\t\tvar url = \"/question/assignment/addAssignment\";\r\n");
      out.write("\t\t$.post(url, post, function(data) {\r\n");
      out.write("\t\t\t//return \"redirect:\";fail\r\n");
      out.write("\t\t\tif (data == \"success\") {\r\n");
      out.write("\t\t\t\tlocation.href = \"/question/assignment/queryAssignment/1\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$.messager.alert('消息反馈', '本次布置作业失败！');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* 添加问题 */\r\n");
      out.write("\tvar count =1;\r\n");
      out.write("\tfunction addOriginal(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar question = $(\"textarea.question[name='add\" +count+ \"']\").val();\r\n");
      out.write("\t\t\tvar answer = $(\"textarea.answer[name='add\" +count+ \"']\").val();\r\n");
      out.write("\t\t\tif(question==\"\"){\r\n");
      out.write("\t\t\t\t$.messager.alert('提示', '请输入问题');\r\n");
      out.write("\t\t\t\treturn ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(answer==\"\"){\r\n");
      out.write("\t\t\t\t$.messager.alert('提示', '请输入参考答案');\r\n");
      out.write("\t\t\t\treturn ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tcount++;\r\n");
      out.write("\t\t\tvar id = \"add\"+count;\r\n");
      out.write("\t\t\tvar original = $(\"#originalShowQuestion\");\r\n");
      out.write("\t\t\tvar html=\"<tr>\" +\r\n");
      out.write("\t\t\t\"<td style='display: none'><input type='checkbox' class='questionNum' name='ck' checked='checked' value='\"+id+\"'></td>\" +\r\n");
      out.write("\t\t\t\"<td style='display: none' id='sentence\"+id+\"'></td>\" +\r\n");
      out.write("\t\t\t\"<td align=center colspan=2><textarea rows='3' cols='80%' class='question' name='\"+id+\"'></textarea></td>\" +\r\n");
      out.write("\t\t\t\"<td align=center><textarea rows='3' cols='50%' class='answer' name='\"+id+\"' ></textarea></td>\" +\r\n");
      out.write("\t\t\t\"<td style='display: none' id='label\"+id+\"'>原始问题</td>\" +\r\n");
      out.write("\t\t\t\"</tr>\";\r\n");
      out.write("\t\t\toriginal.append(html);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"div3\">\r\n");
      out.write("\t\t<font size=\"4\"><label>课文标题：</label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tittle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</font>\r\n");
      out.write("\t\t<div style=\"float: right\">\r\n");
      out.write("\t\t\t<font size=\"4\">课程名：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courseName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&nbsp;</font>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width: 98%; padding-left: 20px\">\r\n");
      out.write("\t\t<font size=\"3\"> ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</font>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"div3\">\r\n");
      out.write("\t\t<font size=\"4\"><label id=\"infor\"></label></font> <img id=\"loading\"\r\n");
      out.write("\t\t\twidth=\"20px\" src=\"");
      if (_jspx_meth_c_005furl_005f9(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"div4\">\r\n");
      out.write("\t\t<form action=\"#\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"textId\" name=\"textId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${textId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"> <input\r\n");
      out.write("\t\t\t\ttype=\"hidden\" name=\"startDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t<table border=\"1\" class=\"editTab\" id=\"multiplechoiceShowQuestion\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"5\" align=\"left\">选择题\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"3%\"><input type=\"checkbox\" id=\"selectAllMultipleChoice\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"checkEvent('multiplechoice','selectAllMultipleChoice')\" /></th>\r\n");
      out.write("\t\t\t\t\t<th width=\"35%\">句子</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"35%\">问题</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"22%\">候选项</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"8%\">答案</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<script src=\"");
      if (_jspx_meth_c_005furl_005f10(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\t\t\t<p id=\"multiplechoiceNextId\" align=\"center\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" onclick=\"multiplechoiceNext()\" class=\"btnPaleGreen\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px\" value=\"下一题\">\r\n");
      out.write("\t\t\t\t<!-- <input type=\"button\" id=\"deeperLastId\" onclick=\"deeperLast()\" class=\"btnGray\" style=\"width: 100px\" value=\"上一题\"> -->\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<table border=\"1\" class=\"editTab\" id=\"factoidShowQuestion\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"5\" align=\"left\">事实类问题\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"3%\"><input type=\"checkbox\" id=\"selectAll\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"checkEvent('ck','selectAll')\" /></th>\r\n");
      out.write("\t\t\t\t\t<th width=\"42%\">句子</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"35%\">问题</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"12%\">参考答案</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"8%\">问题类别</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<p id=\"factoidNextId\" align=\"center\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" onclick=\"factoidNext()\" class=\"btnPaleGreen\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px\" value=\"下一题\">\r\n");
      out.write("\t\t\t\t<!-- <input type=\"button\" id=\"deeperLastId\" onclick=\"deeperLast()\" class=\"btnGray\" style=\"width: 100px\" value=\"上一题\"> -->\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<table border=\"1\" class=\"editTab\" id=\"deeperShowQuestion\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"5\" align=\"left\">深层次问题\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th width=\"3%\"><input type=\"checkbox\" id=\"selectAll\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"checkEvent('ck','selectAll')\" /></th>\r\n");
      out.write("\t\t\t\t\t<th width=\"42%\">句子</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"35%\">问题</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"12%\">参考答案</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"8%\">问题类别</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<p id=\"deeperNextId\" align=\"center\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" onclick=\"deeperNext()\" class=\"btnPaleGreen\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px\" value=\"下一题\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<table border=\"1\" class=\"editTab\" id=\"originalShowQuestion\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"3\" align=\"left\">手动添加问题</th>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th  width=\"10%\"><input type=\"button\" onclick=\"addOriginal()\" class=\"btnGray\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 80px\" value=\"添加\"></th>\r\n");
      out.write("\t\t\t\t\t<th width=\"50%\">问题</th>\r\n");
      out.write("\t\t\t\t\t<th width=\"40%\">参考答案</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<p id=\"submitClick\" align=\"center\">\r\n");
      out.write("\t\t\t\t设置作业标题：<input type=\"text\" name=\"assName\" style=\"width: 200px\"><font color=\"red\">* 必填</font><br><br>\r\n");
      out.write("\t\t\t\t设置作业限时：<select class=\"text\" name=\"assTime\" style=\"width: 200px\">\r\n");
      out.write("\t\t\t\t\t<option value=\"10\">10分钟</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"6\">5分钟</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"15\">15分钟</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"20\">20分钟</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"30\">25分钟</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"30\">30分钟</option>\r\n");
      out.write("\t\t\t\t</select> <font color=\"red\">* 必填</font><br><br>\r\n");
      out.write("\t\t\t\t<input type=\"button\" onclick=\"return addQuestion('questionNum')\"\r\n");
      out.write("\t\t\t\t\tclass=\"btnPaleGreen\" name=\"submit\" value=\"布置作业\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px\"> <input type=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"linkText()\" class=\"btnGray\" value=\"返回课文\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 100px\"> <br> <br>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f11(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f12(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f13(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f14(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f15(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f16(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f17(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f18(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      if (_jspx_meth_c_005furl_005f19(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/question/../com/easyui.jsp(5,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/easyui/themes/default/easyui.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/views/question/../com/easyui.jsp(7,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/resources/easyui/themes/icon.css");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/views/question/../com/easyui.jsp(9,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/resources/easyui/jquery.min.js");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /WEB-INF/views/question/../com/easyui.jsp(11,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/resources/easyui/jquery.easyui.min.js");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /WEB-INF/views/question/../com/easyui.jsp(13,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/resources/easyui/local/easyui-lang-zh_CN.js");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(11,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/resources/css/main.css");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(14,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/resources/js/selectAll.js");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f7 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f7.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(17,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/resources/js/dialog.js");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f8 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f8.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f8.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(19,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f8.setValue("/resources/js/dateFormat.js");
    int _jspx_eval_c_005furl_005f8 = _jspx_th_c_005furl_005f8.doStartTag();
    if (_jspx_th_c_005furl_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f8);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(306,18) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("sentence");
    // /WEB-INF/views/question/questionProduct.jsp(306,18) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionProduct.jsp(306,18) '${sentences}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${sentences}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t&nbsp;&nbsp;\r\n");
          out.write("\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sentence}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("<br>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f9 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f9.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f9.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(315,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f9.setValue("/resources/images/loading.gif");
    int _jspx_eval_c_005furl_005f9 = _jspx_th_c_005furl_005f9.doStartTag();
    if (_jspx_th_c_005furl_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f9);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f10(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f10 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f10.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f10.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(335,16) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f10.setValue("/resources/question/js/multiple-choice/question-generator.js");
    int _jspx_eval_c_005furl_005f10 = _jspx_th_c_005furl_005f10.doStartTag();
    if (_jspx_th_c_005furl_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f10);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f11 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f11.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f11.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(409,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f11.setValue("/resources/question/js/common.js");
    int _jspx_eval_c_005furl_005f11 = _jspx_th_c_005furl_005f11.doStartTag();
    if (_jspx_th_c_005furl_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f11);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f12 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f12.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f12.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(410,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f12.setValue("/resources/question/js/pos.js");
    int _jspx_eval_c_005furl_005f12 = _jspx_th_c_005furl_005f12.doStartTag();
    if (_jspx_th_c_005furl_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f12);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f13(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f13 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f13.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f13.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(411,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f13.setValue("/resources/question/js/srl.js");
    int _jspx_eval_c_005furl_005f13 = _jspx_th_c_005furl_005f13.doStartTag();
    if (_jspx_th_c_005furl_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f13);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f14(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f14 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f14.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f14.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(412,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f14.setValue("/resources/question/js/last.js");
    int _jspx_eval_c_005furl_005f14 = _jspx_th_c_005furl_005f14.doStartTag();
    if (_jspx_th_c_005furl_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f14);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f15(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f15 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f15.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f15.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(413,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f15.setValue("/resources/question/js/mq.js");
    int _jspx_eval_c_005furl_005f15 = _jspx_th_c_005furl_005f15.doStartTag();
    if (_jspx_th_c_005furl_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f15);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f16(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f16 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f16.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f16.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(415,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f16.setValue("/resources/question/js/wipeNeedlessComponent.js");
    int _jspx_eval_c_005furl_005f16 = _jspx_th_c_005furl_005f16.doStartTag();
    if (_jspx_th_c_005furl_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f16);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f17(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f17 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f17.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f17.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(417,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f17.setValue("/resources/question/js/questionGenerator.js");
    int _jspx_eval_c_005furl_005f17 = _jspx_th_c_005furl_005f17.doStartTag();
    if (_jspx_th_c_005furl_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f17);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f18(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f18 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f18.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f18.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(418,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f18.setValue("/resources/question/js/causeResult.js");
    int _jspx_eval_c_005furl_005f18 = _jspx_th_c_005furl_005f18.doStartTag();
    if (_jspx_th_c_005furl_005f18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f18);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f18);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f19(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f19 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f19.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f19.setParent(null);
    // /WEB-INF/views/question/questionProduct.jsp(419,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f19.setValue("/resources/question/js/how.js");
    int _jspx_eval_c_005furl_005f19 = _jspx_th_c_005furl_005f19.doStartTag();
    if (_jspx_th_c_005furl_005f19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f19);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f19);
    return false;
  }
}
