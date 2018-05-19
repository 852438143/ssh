package com.mule.elearing.action;

import com.mule.elearing.po.Comment;
import com.mule.elearing.service.CommentService;
import com.mule.elearing.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.List;

public class CommentAction extends ActionSupport implements ModelDriven{
	private Comment comment=new Comment();
	private PageBean pageBean;
	private CommentService commentService;
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return comment;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public String save(){
		try {
			this.commentService.save(this.comment);
			this.setPageBean(new PageBean());
			this.pageBean.setCurrentPage(1);
			System.out.println("aaa "+this.pageBean.getCurrentPage());
			this.showComments();
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ERROR;
	}
	public String showComments(){
		List<Comment> comments=new ArrayList<Comment>();
		try {
			if(this.comment.getContentId()==null || this.comment.getContentId().equals("")){
				comments = this.commentService.getByPage(this.pageBean.getCurrentPage(),this.comment.getCourseId(),0);
			}
			else {
				comments = this.commentService.getByPage(this.pageBean.getCurrentPage(), this.comment.getContentId(), 1);
			}
			
			ActionContext.getContext().put("comments",comments);
			System.out.println(comments.size()+"~~~");
			int count=this.commentService.getTotal(this.comment.getContentId());
			pageBean.setTotalSize(count);
			int pagesize=5;
			int p=count%pagesize;
			if(p==0){
				pageBean.setTotalPage(count/pagesize);
			}else pageBean.setTotalPage(count/pagesize+1);
			if(count==0)pageBean.setTotalPage(1);
			System.out.println(this.pageBean.getCurrentPage()+"  "+this.pageBean.getTotalPage());
			ActionContext.getContext().getValueStack().set("pageBean", this.pageBean);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
