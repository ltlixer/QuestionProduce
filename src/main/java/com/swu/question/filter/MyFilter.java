package com.swu.question.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swu.question.entity.Student;
import com.swu.question.entity.Teacher;

public class MyFilter implements Filter {  
	  
    /**  
     * Default constructor.   
     */  
    public MyFilter() {  
    }  
  
    /**  
     * @see Filter#destroy()  
     */  
    public void destroy() {  
    }  
  
    /**  
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)  
     */  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String path = httpServletRequest.getContextPath();
		Student student = (Student) httpServletRequest.getSession().getAttribute("stu");
		Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("tea");
		String servletPath=httpServletRequest.getServletPath();
		/*System.out.println(servletPath);
		System.out.println(path);*/
		/*if(student==null&&teacher==null&&!servletPath.equals("/")){
			httpServletResponse.sendRedirect(path);
		}*/
		if(student==null&&teacher==null&&(servletPath.startsWith("/text")||servletPath.startsWith("/answer")||servletPath.startsWith("/evaluate")||servletPath.startsWith("/question")||servletPath.startsWith("/assignment")||servletPath.startsWith("/course"))){
			httpServletResponse.sendRedirect(path+"/filter");
		}else{
			chain.doFilter(request, response);  
		}
    }  
  
    /**  
     * @see Filter#init(FilterConfig)  
     */  
    public void init(FilterConfig fConfig) throws ServletException {  
    }  
  
}  