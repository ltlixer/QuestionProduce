package org.apache.jsp.WEB_002dINF.views.question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class questionPageStu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/views/question/../com/easyui.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
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
      out.write(" \r\n");
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
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      if (_jspx_meth_c_005furl_005f7(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>问题产生</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var multiplechoiceStartTime=\"\";\r\n");
      out.write("var multiplechoiceEndTime=\"\";\r\n");
      out.write("var factoidStartTime=\"\";\r\n");
      out.write("var factoidEndTime=\"\";\r\n");
      out.write("var deeperStartTime=\"\";\r\n");
      out.write("var deeperEndTime=\"\";\r\n");
      out.write("var originalStartTime=\"\";\r\n");
      out.write("var originalEndTime=\"\";\r\n");
      out.write("var secondViewMultiplechoice = false;\r\n");
      out.write("var secondViewFactoid = false;/* 表示是否是第二次点击事实类问题的下一题：当点上一步时记录标注 为true 不计时 */\r\n");
      out.write("var secondViewDeeper = false;/* 表示是否是第二次点击深层次问题的下一题：当点上一步时记录标注  为true 不计时 */\r\n");
      out.write("\r\n");
      out.write("$(function() {\r\n");
      out.write("\t\ttimeShow();\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide();\r\n");
      out.write("\t\t$(\"#FactoidQuestion\").hide();\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide();\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide();\r\n");
      out.write("\t\t$(\"#submitAss\").hide();\r\n");
      out.write("\t\t$(\"#multiplechoiceNextId\").hide();\r\n");
      out.write("\t\t$(\"#factoidNextId\").hide();\r\n");
      out.write("\t\t$(\"#deeperNextId\").hide();\r\n");
      out.write("\t\t$(\"#deeperLastId\").hide();\r\n");
      out.write("\t\t$(\"#originalLastId\").hide();\r\n");
      out.write("\t\tvar MultiplechoiceSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tif(MultiplechoiceSize!='0'){\r\n");
      out.write("    \t\tmultiplechoiceStartTime =new Date();\r\n");
      out.write("    \t\tmultiplechoiceQuestionShow(0);\r\n");
      out.write("    \t}else if(FactoidSize!='0'){\r\n");
      out.write("    \t\tfactoidStartTime =new Date();\r\n");
      out.write("    \t\tfactoidQuestionShow(0);\r\n");
      out.write("    \t}else if(DeeperSize!='0'){\r\n");
      out.write("    \t\tdeeperStartTime =new Date(); \r\n");
      out.write("    \t\tdeeperQuestionShow(0);\r\n");
      out.write("    \t}else if(OriginalSize!='0'){\r\n");
      out.write("    \t\toriginalStartTime = new Date(); \r\n");
      out.write("    \t\tOriginalQuestionShow(0)\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("\t}); \r\n");
      out.write("\t//倒计时函数\r\n");
      out.write("\tvar secs = 60; //倒计时的秒数 \r\n");
      out.write("\tvar min =");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("-1;//分钟\r\n");
      out.write("\tvar m =");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";//分钟\r\n");
      out.write("    function timeShow(){\r\n");
      out.write("    \tsecs--\r\n");
      out.write("    \tif(min==0&&secs==0){\r\n");
      out.write("    \t\t$(\"label#timeShow\").text(\"0分0秒\");\r\n");
      out.write("    \t\tsubmitTest();\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t $(\"label#timeShow\").text(min+\"分\"+secs+\"秒\");\r\n");
      out.write("        if(secs==0){\r\n");
      out.write("        \tmin--;\r\n");
      out.write("        \tsecs=60;\r\n");
      out.write("        }\r\n");
      out.write("        setTimeout(\"timeShow()\",1000);\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
      out.write("    function multiplechoiceQuestionShow(sec){\r\n");
      out.write("\t\tvar MultiplechoiceSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t$(\"#MultiplechoiceQuestion\").show(sec);\r\n");
      out.write("\t\t\tif(DeeperSize!='0'||OriginalSize!='0'||FactoidSize!='0'){\r\n");
      out.write("\t\t\t\t$(\"#multiplechoiceNextId\").show();\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\"#submitAss\").show();\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction factoidQuestionShow(sec){\r\n");
      out.write("\t\tvar MultiplechoiceSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\t$(\"#FactoidQuestion\").show(sec);\r\n");
      out.write("\t\t\tif(DeeperSize!='0'||OriginalSize!='0'){\r\n");
      out.write("\t\t\t\t$(\"#factoidNextId\").show();\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$(\"#submitAss\").show();\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\t//处理上一题按钮\r\n");
      out.write("\t\t\tif(MultiplechoiceSize!='0'){\r\n");
      out.write("\t\t\t\t$(\"#factoidLastId\").show();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction deeperQuestionShow(sec){\r\n");
      out.write("\t\tvar MultiplechoiceSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").show(sec);\r\n");
      out.write("\t\t//处理下一题按钮\r\n");
      out.write("\t\tif(OriginalSize!='0'||MultiplechoiceSize!='0'){\r\n");
      out.write("\t\t\t$(\"#deeperNextId\").show();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(\"#submitAss\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//处理上一题按钮\r\n");
      out.write("\t\tif(FactoidSize!='0'){\r\n");
      out.write("\t\t\t$(\"#deeperLastId\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction OriginalQuestionShow(sec){\r\n");
      out.write("\t\tvar MultiplechoiceSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").show(sec);\r\n");
      out.write("\t\t$(\"#submitAss\").show();\r\n");
      out.write("\t\t//处理上一题按钮\r\n");
      out.write("\t\tif(FactoidSize!='0'||DeeperSize!='0'||MultiplechoiceSize!='0'){\r\n");
      out.write("\t\t\t$(\"#originalLastId\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction multiplechoiceNext(){\r\n");
      out.write("    \tif(!secondViewMultiplechoice){\r\n");
      out.write("    \t\tmultiplechoiceEndTime=new Date();\r\n");
      out.write("    \t}\r\n");
      out.write("    \tvar FactoidSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide(200);\r\n");
      out.write("    \t$(\"#FactoidQuestion\").hide();\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide();\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide();\r\n");
      out.write("\t\tif(FactoidSize!='0'){\r\n");
      out.write("    \t\tif(!secondViewMultiplechoice){//第一次计时 点击上一步后不计时\r\n");
      out.write("    \t\t\tfactoidStartTime=new Date();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tfactoidQuestionShow(200);\r\n");
      out.write("    \t}else if(DeeperSize!='0'){\r\n");
      out.write("    \t\tif(!secondViewFactoid){//第一次计时 点击上一步后不计时\r\n");
      out.write("    \t\t\tdeeperStartTime=new Date();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tdeeperQuestionShow(200);\r\n");
      out.write("    \t}else if(OriginalSize!='0'){\r\n");
      out.write("    \t\tif(!secondViewFactoid){//第一次计时 点击上一步后不计时\r\n");
      out.write("        \t\toriginalStartTime=new Date();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tOriginalQuestionShow(200)\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
      out.write("    function factoidNext(){\r\n");
      out.write("    \tif(!secondViewFactoid){\r\n");
      out.write("    \t\tfactoidEndTime=new Date();\r\n");
      out.write("    \t}\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide();\r\n");
      out.write("    \t$(\"#FactoidQuestion\").hide(200);\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide();\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide();\r\n");
      out.write("    \tif(DeeperSize!='0'){\r\n");
      out.write("    \t\tif(!secondViewFactoid){//第一次计时 点击上一步后不计时\r\n");
      out.write("    \t\t\tdeeperStartTime=new Date();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tdeeperQuestionShow(200);\r\n");
      out.write("    \t}else if(OriginalSize!='0'){\r\n");
      out.write("    \t\tif(!secondViewFactoid){//第一次计时 点击上一步后不计时\r\n");
      out.write("        \t\toriginalStartTime=new Date();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tOriginalQuestionShow(200)\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function deeperNext(){\r\n");
      out.write("    \tif(!secondViewDeeper){\r\n");
      out.write("    \t\tdeeperEndTime=new Date();//只有第一次点击下一步时计时\r\n");
      out.write("    \t}\r\n");
      out.write("    \tvar OriginalSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide();\r\n");
      out.write("    \t$(\"#FactoidQuestion\").hide();\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide(200);\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide();\r\n");
      out.write("    \tif(OriginalSize!='0'){\r\n");
      out.write("    \t\tif(!secondViewDeeper){\r\n");
      out.write("        \t\toriginalStartTime=new Date();\r\n");
      out.write("    \t\t}\r\n");
      out.write("    \t\tOriginalQuestionShow(200);\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    function factoidLast(){\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide();\r\n");
      out.write("    \t$(\"#FactoidQuestion\").hide(200);\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide();\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide();\r\n");
      out.write("    \tvar MultiplechoiceSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tif(MultiplechoiceSize!='0'){\r\n");
      out.write("    \t\tsecondViewMultiplechoice = true;\r\n");
      out.write("    \t\tmultiplechoiceQuestionShow(200);\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("    function deeperLast(){\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide();\r\n");
      out.write("    \t$(\"#FactoidQuestion\").hide();\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide(200);\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide();\r\n");
      out.write("    \tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tif(FactoidSize!='0'){\r\n");
      out.write("    \t\tsecondViewFactoid = true;\r\n");
      out.write("    \t\tfactoidQuestionShow(200);\r\n");
      out.write("    \t}\r\n");
      out.write("    }\r\n");
      out.write("\tfunction originalLast(){\r\n");
      out.write("\t\t$(\"#MultiplechoiceQuestion\").hide();\r\n");
      out.write("\t\t$(\"#FactoidQuestion\").hide();\r\n");
      out.write("\t\t$(\"#DeeperQuestion\").hide();\r\n");
      out.write("\t\t$(\"#OriginalQuestion\").hide(200);\r\n");
      out.write("\t\tvar FactoidSize = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tvar DeeperSize=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("    \tif(DeeperSize!='0'){\r\n");
      out.write("    \t\tsecondViewDeeper = true;\r\n");
      out.write("    \t\tdeeperQuestionShow(200);\r\n");
      out.write("    \t}else if(FactoidSize!='0'){\r\n");
      out.write("    \t\tsecondViewFactoid = true;\r\n");
      out.write("    \t\tfactoidQuestionShow(200);\r\n");
      out.write("    \t}\r\n");
      out.write("\t}\r\n");
      out.write("    \r\n");
      out.write("\tfunction submitTip(title,mesg){\r\n");
      out.write("\t\tif(originalStartTime!=\"\"){\r\n");
      out.write("\t\t\toriginalEndTime=new Date();\r\n");
      out.write("\t\t}else if(deeperStartTime!=\"\"){\r\n");
      out.write("\t\t\tdeeperEndTime = new Date();\r\n");
      out.write("\t\t}else if(factoidStartTime !=\"\"){\r\n");
      out.write("\t\t\tfactoidEndTime = new Date();\r\n");
      out.write("\t\t}else if(multiplechoiceStartTime!=\"\"){\r\n");
      out.write("\t\t\tmultiplechoiceEndTime=new Date();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$.messager.confirm(title, mesg, function(isSure) {\r\n");
      out.write("\t\t\tif(isSure){\r\n");
      out.write("\t\t\t\tvar ma = document.getElementsByClassName(\"multiplechoiceAnswer\");\r\n");
      out.write("\t\t\t\tif(ma.length>0){\r\n");
      out.write("\t\t\t\t\tfor(var i = 0;i<ma.length;i++){\r\n");
      out.write("\t\t\t\t\t\tvar an = getRadioValue(\"mcanswers\"+(i+1));\r\n");
      out.write("\t\t\t\t\t\tvar ans = document.getElementById(\"answers\"+(i+1));\r\n");
      out.write("\t\t\t\t\t\tans.value=an;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(multiplechoiceStartTime!=\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#multiplechoiceStartTime\").val(multiplechoiceStartTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t\t$(\"#multiplechoiceEndTime\").val(multiplechoiceEndTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(factoidStartTime!=\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#factoidStartTime\").val(factoidStartTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t\t$(\"#factoidEndTime\").val(factoidEndTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(deeperStartTime!=\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#deeperStartTime\").val(deeperStartTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t\t$(\"#deeperEndTime\").val(deeperEndTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t}\t\r\n");
      out.write("\t\t\t\tif(originalStartTime!=\"\"){\r\n");
      out.write("\t\t\t\t\t$(\"#originalStartTime\").val(originalStartTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t\t$(\"#originalEndTime\").val(originalEndTime.format(\"yyyy-MM-dd hh:mm:ss\"));\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#useTime\").val(m-min);\r\n");
      out.write("\t\t\t\t  $(\"#submitbt\").click();  \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}); \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getRadioValue(name){\r\n");
      out.write("\t\tvar radioes = document.getElementsByName(name);\r\n");
      out.write("\t\tfor(var i=0;i<radioes.length;i++)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tif(radioes[i].checked){\r\n");
      out.write("\t\treturn radioes[i].value;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<div class=\"div3\">\r\n");
      out.write("\t\t<font size=\"4\"><label>问题（共");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${questionsize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("小题）</label></font>\r\n");
      out.write("\t\t<div style=\"float: right;\"><font size=\"4\" color=\"red\">测试总时间：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("分钟\r\n");
      out.write("\t\t， 剩余时间<label id=\"timeShow\"></label></font>&nbsp;&nbsp;&nbsp;&nbsp;</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"div4\" style=\"width: 98%\">\r\n");
      out.write("\t\t<form id=\"submitFormId\" action=\"/question/answer/submitAnswer\" method=\"post\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"assId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" id=\"useTime\" name=\"useTime\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${assTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"multiplechoiceStartTime\" name=\"multiplechoiceStartTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"multiplechoiceEndTime\" name=\"multiplechoiceEndTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"factoidStartTime\" name=\"factoidStartTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"factoidEndTime\" name=\"factoidEndTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"deeperStartTime\" name=\"deeperStartTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"deeperEndTime\" name=\"deeperEndTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"originalStartTime\" name=\"originalStartTime\" value=\"\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"originalEndTime\" name=\"originalEndTime\" value=\"\">\r\n");
      out.write("\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\"  class=\"btn2\"\r\n");
      out.write("\t\t\t\tname=\"submit\" id=\"submitbt\" value=\"提交作业\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" id=\"submitAss\" onclick=\"return submitTip('确认','您确定提交作业吗？')\" class=\"btnPaleGreen\" style=\"width: 100px\" value=\"提交作业\">\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
    // /WEB-INF/views/question/questionPageStu.jsp(13,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/views/question/questionPageStu.jsp(16,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/resources/js/dialog.js");
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
    // /WEB-INF/views/question/questionPageStu.jsp(18,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f7.setValue("/resources/js/dateFormat.js");
    int _jspx_eval_c_005furl_005f7 = _jspx_th_c_005furl_005f7.doStartTag();
    if (_jspx_th_c_005furl_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f7);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/views/question/questionPageStu.jsp(303,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize==0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t<div class=\"div3\">\r\n");
        out.write("\t\t<font size=\"4\">阅读<label>课文《");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${textTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("》回答下列问题 </label>\r\n");
        out.write("\t\t</font>\r\n");
        out.write("\t\t<span style=\"float: right;\"><font size=\"3\">课程名：");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${courseName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</font>&nbsp;&nbsp;</span>\r\n");
        out.write("\t</div>\r\n");
        out.write("\t<br>\r\n");
        out.write("\t<div style=\"width: 98%; padding-left: 20px\">\r\n");
        out.write("\t\t<font size=\"3\"> ");
        if (_jspx_meth_c_005fforEach_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t</font>\r\n");
        out.write("\t</div>\r\n");
        out.write("\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /WEB-INF/views/question/questionPageStu.jsp(311,18) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("sentence");
    // /WEB-INF/views/question/questionPageStu.jsp(311,18) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(311,18) '${texts}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${texts}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /WEB-INF/views/question/questionPageStu.jsp(328,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${MultiplechoiceSize>0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<table border=\"1\" class=\"editTab\" id=\"MultiplechoiceQuestion\" align=\"center\">\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th colspan=\"3\" align=\"left\">选择题（共");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("小题）</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th width=\"7%\">题号</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"60%\">问题</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"33%\">答案</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fif_005f1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t<input type=\"button\" id=\"multiplechoiceNextId\" onclick=\"multiplechoiceNext()\" class=\"btnPaleGreen\" style=\"width: 100px\" value=\"下一题\">\r\n");
        out.write("\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t</table>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/views/question/questionPageStu.jsp(338,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(338,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(338,5) '${0}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${0}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f1);
    // /WEB-INF/views/question/questionPageStu.jsp(339,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("question");
    // /WEB-INF/views/question/questionPageStu.jsp(339,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(339,5) '${MultiplechoiceQuestions}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${MultiplechoiceQuestions}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f1(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td align=\"center\">问题 ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(".</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.question}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t<td class=\"multiplechoiceAnswer\">\r\n");
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fforEach_005f2(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"answers");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" name=\"answers\" value=\"\">\r\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"qids\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.qId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"answerold\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.answer}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /WEB-INF/views/question/questionPageStu.jsp(340,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(340,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(340,5) '${i+1}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${i+1}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /WEB-INF/views/question/questionPageStu.jsp(346,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("distracter");
    // /WEB-INF/views/question/questionPageStu.jsp(346,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(346,7) '${question.distracter}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${question.distracter}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"radio\" name=\"mcanswers");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${distracter.distracter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><label>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${distracter.distracter}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</label>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent(null);
    // /WEB-INF/views/question/questionPageStu.jsp(364,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize>0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<table border=\"1\" class=\"editTab\" id=\"FactoidQuestion\" align=\"center\">\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th colspan=\"3\" align=\"left\">事实类问题（共");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${FactoidSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("小题）</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th width=\"7%\">题号</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"60%\">问题</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"33%\">答案</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f2(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f3(_jspx_th_c_005fif_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t<input type=\"button\" id=\"factoidNextId\" onclick=\"factoidNext()\" class=\"btnPaleGreen\" style=\"width: 100px\" value=\"下一题\">\r\n");
        out.write("\t\t\t\t\t<input type=\"button\" id=\"factoidLastId\" onclick=\"factoidLast()\" class=\"btnGray\" style=\"width: 100px\" value=\"上一题\">\r\n");
        out.write("\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t</table>\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /WEB-INF/views/question/questionPageStu.jsp(374,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(374,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(374,5) '${0}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${0}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f2);
    // /WEB-INF/views/question/questionPageStu.jsp(375,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setVar("question");
    // /WEB-INF/views/question/questionPageStu.jsp(375,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(375,5) '${FactoidQuestions}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${FactoidQuestions}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
      if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f3(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td align=\"center\">问题 ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(".</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.question}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td><textarea  name=\"answers\" class=\"easyui-validatebox\" data-options=\"required:true\" missingMessage=\"请输入答案\"  style='width: 300px'></textarea>\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"qids\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.qId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"answerold\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.answer}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/views/question/questionPageStu.jsp(376,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(376,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f3.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(376,5) '${i+1}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${i+1}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f3 = _jspx_th_c_005fset_005f3.doStartTag();
    if (_jspx_th_c_005fset_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent(null);
    // /WEB-INF/views/question/questionPageStu.jsp(395,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize>0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<table border=\"1\" class=\"editTab\" id=\"DeeperQuestion\" align=\"center\">\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th colspan=\"3\" align=\"left\">深层次问题（共");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${DeeperSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("小题）</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th width=\"7%\">题号</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"60%\">问题</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"33%\">答案</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f4(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f4(_jspx_th_c_005fif_005f3, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t<input type=\"button\" id=\"deeperNextId\" onclick=\"deeperNext()\" class=\"btnPaleGreen\" style=\"width: 100px\" value=\"下一题\">\r\n");
        out.write("\t\t\t\t\t<input type=\"button\" id=\"deeperLastId\" onclick=\"deeperLast()\" class=\"btnGray\" style=\"width: 100px\" value=\"上一题\">\r\n");
        out.write("\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t</table>\r\n");
        out.write("\t\t\t\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/views/question/questionPageStu.jsp(405,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(405,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f4.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(405,5) '${0}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${0}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f4 = _jspx_th_c_005fset_005f4.doStartTag();
    if (_jspx_th_c_005fset_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
    // /WEB-INF/views/question/questionPageStu.jsp(406,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVar("question");
    // /WEB-INF/views/question/questionPageStu.jsp(406,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(406,5) '${DeeperQuestions}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${DeeperQuestions}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f5(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td align=\"center\">问题 ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(".</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.question}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td><textarea  name=\"answers\" class=\"easyui-validatebox\" data-options=\"required:true\" missingMessage=\"请输入答案\"  style='width: 300px'></textarea>\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"qids\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.qId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"answerold\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.answer}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/views/question/questionPageStu.jsp(407,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(407,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f5.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(407,5) '${i+1}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${i+1}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f5 = _jspx_th_c_005fset_005f5.doStartTag();
    if (_jspx_th_c_005fset_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f4.setParent(null);
    // /WEB-INF/views/question/questionPageStu.jsp(426,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize>0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
    if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<table border=\"1\" class=\"editTab\" id=\"OriginalQuestion\" align=\"center\">\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th colspan=\"3\" align=\"left\">原始问题（共");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${OriginalSize}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("小题）</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t<tr>\r\n");
        out.write("\t\t\t\t\t<th width=\"7%\">题号</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"60%\">问题</th>\r\n");
        out.write("\t\t\t\t\t<th width=\"33%\">答案</th>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fset_005f6(_jspx_th_c_005fif_005f4, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_c_005fforEach_005f5(_jspx_th_c_005fif_005f4, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t<tr>\r\n");
        out.write("\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
        out.write("\t\t\t\t\t<input type=\"button\" id=\"originalLastId\" onclick=\"originalLast()\" class=\"btnGray\" style=\"width: 100px\" value=\"上一题\">\r\n");
        out.write("\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t</tr>\r\n");
        out.write("\t\t\t</table>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f6 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f4);
    // /WEB-INF/views/question/questionPageStu.jsp(436,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(436,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f6.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(436,5) '${0}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${0}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f6 = _jspx_th_c_005fset_005f6.doStartTag();
    if (_jspx_th_c_005fset_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f6);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f4);
    // /WEB-INF/views/question/questionPageStu.jsp(437,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setVar("question");
    // /WEB-INF/views/question/questionPageStu.jsp(437,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(437,5) '${OriginalQuestions}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${OriginalQuestions}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f5 = _jspx_th_c_005fforEach_005f5.doStartTag();
      if (_jspx_eval_c_005fforEach_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f7(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t\t<td align=\"center\">问题 ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(".</td>\r\n");
          out.write("\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.question}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\t\t\t\t\t\t\t<td><textarea  name=\"answers\" class=\"easyui-validatebox\" data-options=\"required:true\" missingMessage=\"请输入答案\"  style='width: 300px'></textarea>\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"qids\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.qId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"answerold\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.answer}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f5.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f7 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f7.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /WEB-INF/views/question/questionPageStu.jsp(438,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setVar("i");
    // /WEB-INF/views/question/questionPageStu.jsp(438,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f7.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/question/questionPageStu.jsp(438,5) '${i+1}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${i+1}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f7 = _jspx_th_c_005fset_005f7.doStartTag();
    if (_jspx_th_c_005fset_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f7);
    return false;
  }
}
