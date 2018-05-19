package com.mule.elearing.dao;

import com.mule.elearing.po.Comment;

import java.util.List;

public interface CommentDao {
	public boolean save(Comment comment);

	List<Comment> getComment();

	int getTotal(String courseId);

	/**
	 * flag = 0时通过courseId查询
	 * flag= 1时通过contentId查询
	 * @param currentPage
	 * @param courseId
	 * @return
	 */
	List<Comment> getByPage(int currentPage, String courseId,int index);

}
