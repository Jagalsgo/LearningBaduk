package com.namix.LearningBaduk.service;

import java.util.Collection;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface FileService {
	
	String upload(CommonsMultipartFile multipartFile);
	boolean remove(String url);
	void remove(Collection<String> urls);

}
