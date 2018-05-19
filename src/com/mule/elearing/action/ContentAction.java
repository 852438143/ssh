package com.mule.elearing.action;

import com.mule.elearing.po.Content;
import com.mule.elearing.service.CommentService;
import com.mule.elearing.service.ContentService;
import com.mule.elearing.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.mule.elearing.po.Course;

import java.util.ArrayList;
import java.util.List;

public class ContentAction extends ActionSupport implements ModelDriven{
	private Content content=new Content();
	private ContentService contentService;
	private CourseService courseService;
	private CommentService commentService;
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public ContentService getContentService() {
		return contentService;
	}
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return content;
	}


	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}


	/**
	 *
	 * * @return
	 */
	public String getContentsByCourseId(){
		List<Content> contents=new ArrayList<Content>();
		try {
//			记得测试这个类有没有用过
			contents=this.contentService.getContentsByCourseId(this.content.getCourseId());
			ActionContext.getContext().put("contents", contents);
			System.out.println(contents.size());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String showClass(){
		try {
			Content c=this.contentService.getContentById(this.content.getContentId());
			ActionContext.getContext().getSession().put("content", c);
			Course course=this.courseService.getCourse(c.getCourseId());
			ActionContext.getContext().getSession().put("course", course);

			/*PageBean pageBean=new PageBean();
			pageBean.setCurrentPage(1);
			List<Comment> comment=new ArrayList<Comment>();
			comment=this.commentService.getByPage(pageBean.getCurrentPage());
			
			System.out.println(comment.size()+"~~~~");
			ActionContext.getContext().put("Comment",comment);
			int count=this.commentService.getTotal();
			pageBean.setTotalSize(count);
			int pagesize=5;
			int p=count%pagesize;
			if(p==0){
				pageBean.setTotalPage(count/pagesize);
			}else {pageBean.setTotalPage(count/pagesize+1);}
			if(count==0)pageBean.setTotalPage(1);
			System.out.println(pageBean.getTotalPage()+" !!!!"+p+"   "+count);
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);*/
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
