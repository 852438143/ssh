package com.mule.elearing.action;

import com.mule.elearing.po.Comment;
import com.mule.elearing.po.Content;
import com.mule.elearing.po.Student;
import com.mule.elearing.service.CommentService;
import com.mule.elearing.service.ContentService;
import com.mule.elearing.service.CourseService;
import com.mule.elearing.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.mule.elearing.po.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseAction extends ActionSupport implements ModelDriven{
	private CourseService courseService;
	private Comment comment=new Comment();
	private ContentService contentService;
	private CommentService commentService;
	private Course course=new Course();
	private PageBean pageBean;
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
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
		return course;
	}
	/*public String getCourses(){
		List<Course> course=new ArrayList<Course>();
		try {
			course=this.courseService.getByPage(pageBean.getCurrentPage());
			System.out.println(course.size()+"~~~~");
			ActionContext.getContext().put("course", course);
			int count=this.courseService.getTotal();
			pageBean.setTotalSize(count);
			int pagesize=10;
			int p=count%pagesize;
			if(p==0){
				pageBean.setTotalPage(count/pagesize);
			}else pageBean.setTotalPage(count/pagesize+1);
			ActionContext.getContext().getValueStack().set("pageBean", this.pageBean);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}*/

    /**
     * 显示课程信息和目录
     * @return
     */
	public String showCourseMessage(){
		try {
			
			List<Content> contents=new ArrayList<Content>();
			System.out.println(this.course);
			Course course=this.courseService.getCourse(this.course.getCourseId());
			ActionContext.getContext().put("course", course);
			ActionContext.getContext().getSession().put("course",course);
			System.out.println("!!!!"+this.course.getCourseId());
			contents=this.contentService.getContentsByCourseId(this.course.getCourseId());
			contents.sort((o1,o2)->o1.getField1().compareTo(o2.getField1()));
			ActionContext.getContext().put("contents", contents);

			List<Comment> comments=new ArrayList<Comment>();
			comments=this.commentService.getByPage(1,this.course.getCourseId(),0);
			ActionContext.getContext().put("comments",comments);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String getCommentsAndPapers(){
		String result = SUCCESS;
		return result;
	}

	public String showCoursesByStudent(){
        String result =ERROR;
        List<Course> courses = courseService.getCoursesByStudentId(((Student)ActionContext.getContext().getSession().get("student")).getStudentId());
        if(courses!=null&&courses.size()>0){
            result = SUCCESS;
        }
        ActionContext.getContext().put("courses",courses);
        return result;
    }


    public String removeStudentCourse(){
        String result = ERROR;
        this.courseService.removeStudentCourse(((Student)ActionContext.getContext().getSession().get("student")).getStudentId(),this.course.getCourseId());
		result = SUCCESS;
        return result;
    }

	public String saveStudentCourse(){
		String result = SUCCESS;
        List<Content> contents=new ArrayList<Content>();
        System.out.println(this.course);
        Course course=this.courseService.getCourse(this.course.getCourseId());
        ActionContext.getContext().put("course", course);
        System.out.println("!!!!"+this.course.getCourseId());
        contents=this.contentService.getContentsByCourseId(this.course.getCourseId());
		contents.sort((o1,o2)->o1.getField1().compareTo(o2.getField1()));
        ActionContext.getContext().put("contents", contents);
        String studentId = ((Student)ActionContext.getContext().getSession().get("student")).getStudentId();
        String msg = "添加课程成功";
        this.courseService.saveStudentCourse(studentId,this.course.getCourseId(),this.course.getCourseName());
        ActionContext.getContext().put("msg",msg);
		return result ;
	}

	public String Save(){
		try {
			this.courseService.Save(course);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String Delete(){
		try {
			this.courseService.Delete(this.course.getCourseId());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String Update(){
		try {
			this.courseService.Update(course);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String getCourseById(){
		try {
			this.courseService.getCourseById(this.course.getCourseId());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String setTime(){
		try {
			this.courseService.setTime(course);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String getByKeyword(){
		List<Course> courses=new ArrayList<Course>();
		try {
            if(this.course.getKeyword()==null||this.course.getKeyword().equals("")){
                this.course.setKeyword("前端开发");
            }
			courses=this.courseService.getCourseByKeywords(this.course.getKeyword());
			System.out.println("~~~~~~"+courses.size());
			ActionContext.getContext().put("kcourse", courses);
			ActionContext.getContext().put("Keywords", this.course.getKeyword());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	public String getCourseByKeywordsOrName(){
		List<Course> courses=new ArrayList<Course>();
		try {
			System.out.println("getCourseByKeywordsOrName");
			courses=this.courseService.getCourseByKeywordsOrName(this.course.getKeyword());
			System.out.println("~~~~~~"+courses.size());
			ActionContext.getContext().put("kcourse", courses);
			//ActionContext.getContext().put("Keyword", null);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

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
}
