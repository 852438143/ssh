package com.mule.elearing.dao;

import com.mule.elearing.po.Content;

import java.util.List;

public interface ContentDao {
	public List<Content> getContentsByCourseId(String courseId);
	public Content getContentById(String contentId);

    void save(Content content );
}
