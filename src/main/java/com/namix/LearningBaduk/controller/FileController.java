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
						byte[] bytes = file.getBytes();
						String uploadPath =request.getServletContext().getRealPath("/img");
						File uploadFile = new File(uploadPath);
						
						if(!uploadFile.exists()) {
							uploadFile.mkdir();
						}
						
						fileName = UUID.randomUUID().toString();
						uploadPath = uploadPath + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
						
						out.write(bytes);
						printWriter = response.getWriter();
						response.setContentType("text/html");
						String fileUrl = request.getContextPath() + "/img/" + fileName;
						
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
