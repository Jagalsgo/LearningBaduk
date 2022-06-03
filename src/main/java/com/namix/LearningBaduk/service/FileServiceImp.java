package com.namix.LearningBaduk.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.namix.LearningBaduk.ckeditor.Consts;

@Service
public class FileServiceImp implements FileService {

	@Override
	public String upload(CommonsMultipartFile multipartFile){

		
		return null;
	}

	@Override
	public boolean remove(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Collection<String> urls) {
		// TODO Auto-generated method stub
		
	}

}
