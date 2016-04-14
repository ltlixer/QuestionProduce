package com.swu.question.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadDownloadFile {

	/**
	 * 提供一个SpringMVC单文件上传的方法
	 * @param file  待上传的文件
	 * @param realPath 文件上传保存的路径
	 * @return
	 */
	public String uploadfile(MultipartFile file, String realPath) {
		String message = "";
		File tmpFile = new File(realPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		if (file.isEmpty()) {
			message = "NoFile";
			System.out.println("文件未上传");
		} else {
			// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
			System.out.println(file.getOriginalFilename());
			String fileName = makeFileName(file.getOriginalFilename());
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(realPath, fileName));
				message = fileName;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = "error";
				e.printStackTrace();
			}
		}
		return message;
	}
	/**
	 * 提供一个文件下载的方法
	 * @param response
	 * @param path
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public String download(HttpServletResponse response, String path,
			String fileName) throws Exception {
		File file = new File(path + "\\" + fileName);
		
		// 如果文件不存在
		if (!file.exists()) {
			System.out.println("文件不存在");
			return "文件不存在";
		}
		// 处理文件名
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		// 设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename="
				+ URLEncoder.encode(realname, "UTF-8"));
		// 读取要下载的文件，保存到文件输入流
		FileInputStream in = new FileInputStream(path + "\\" + fileName);
		// 创建输出流
		OutputStream out = response.getOutputStream();
		// 创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将输入流中的内容读取到缓冲区当中
		while ((len = in.read(buffer)) > 0) {
			// 输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		// 关闭文件输入流
		in.close();
		// 关闭输出流
		out.close();
		return "success";
	}
	/**
	 * @Method: makeFileName
	 * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
	 * @param filename
	 *            文件的原始名称
	 * @return uuid+"_"+文件的原始名称
	 */
	private String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}
	
	
	
	public String[] uploadfiles(MultipartFile[] files, String realPath) {
		/*
		 * 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
		 * 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
		 * 并且上传多个文件时，前台表单中的所有<input
		 * type="file"/>的name都应该是files，否则参数里的files无法获取到所有上传的文件
		 */
		String[] message = new String[2];
		File tmpFile = new File(realPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		int count = 0;
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				System.out.println("文件未上传");
			} else {
				// 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
				// String realPath =
				// request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
				System.out.println(file.getOriginalFilename() + "aaaaaaaa");// file.getOriginalFilename()
				String fileName = makeFileName(file.getOriginalFilename());
				System.out.println(fileName);
				try {
					FileUtils.copyInputStreamToFile(file.getInputStream(),
							new File(realPath, fileName));
					message[count] = fileName;
					count++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}// for
		return message;
	}

}
