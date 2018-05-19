package com.mule.elearing.service;

import com.mule.elearing.po.Comment;
import com.mule.elearing.dao.CommentDao;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
	private CommentDao commentDao;

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	public boolean save(Comment comment){
		return this.commentDao.save(comment);
	}


	public List<Comment> getByPage(int currentPage,String courseId ,int index){
		List<Comment> comment=new ArrayList<Comment>();
		try {
			comment=this.commentDao.getByPage(currentPage,courseId,index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}
	public int getTotal(String courseId){
		return this.commentDao.getTotal(courseId);
	}
}
