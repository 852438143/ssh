package com.mule.elearing.service;

import com.mule.elearing.dao.ContentDao;
import com.mule.elearing.po.Content;

import java.util.ArrayList;
import java.util.List;

public class ContentService {
	private ContentDao contentDao;

	public ContentDao getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}
	public List<Content>  getContentsByCourseId(String courseId){
		System.out.println("!!!!!!!!!!!!");
		List<Content> contents=new ArrayList<Content>();
		try {
			contents=this.contentDao.getContentsByCourseId(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}

	public void save(List<Content> contents) {
		for(Content content:contents)
			contentDao.save(content);
	}

	public Content getContentById(String contentId){
		return this.contentDao.getContentById(contentId);
	}
}
