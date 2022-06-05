package com.namix.LearningBaduk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

@Controller
@RequestMapping("/file/")
public class FileController {

	
	@PostMapping("imgUpload")
	@ResponseBody
	public String imgUpload(HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiFile) throws IOException {
	
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		
		if(file != null) {
			if(file.getSize() > 0 && org.codehaus.plexus.util.StringUtils.isNotBlank(file.getName())) {
				if(file.getContentType().toLowerCase().startsWith("image/")) {
					
					try {
						
						String fileName = file.getName();
						System.out.println("fileName1 : " + fileName);
						byte[] bytes = file.getBytes();
						String uploadPath =request.getServletContext().getRealPath("/img");
						System.out.println("uploadPath1 : " + uploadPath);
						File uploadFile = new File(uploadPath);
						System.out.println("uploadFile : "+uploadFile);
						
						if(!uploadFile.exists()) {
							uploadFile.mkdir();
						}
						
						fileName = UUID.randomUUID().toString();
						System.out.println("fileName2 : " + fileName);
						uploadPath = uploadPath + "/" + fileName;
						System.out.println("uploadPath2 : " + uploadPath);
						out = new FileOutputStream(new File(uploadPath));
						
						out.write(bytes);
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath() + "/img/" + fileName;
						System.out.println("fileUrl : "+fileUrl);
						
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						
						printWriter.println(json);
						
					}catch (IOException e) {
						e.printStackTrace();
					}finally {
						if(out != null) {
							out.close();
						}
						if(printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
		
		return null;
		
	}
	
}
