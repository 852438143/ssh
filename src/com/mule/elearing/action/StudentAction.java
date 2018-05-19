package com.mule.elearing.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.mule.elearing.po.Course;
import com.mule.elearing.po.Student;
import com.mule.elearing.service.CourseService;
import com.mule.elearing.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentAction extends ActionSupport implements ModelDriven{
	private Student student=new Student();
	private StudentService studentService;
	public CourseService courseService;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String login(){
	//	System.out.println(student.getId());
		try {
		//	System.out.println(this.personService.PersonExists(this.person)==true);
			if(this.studentService.StudentExists(this.student)){
				Student s=this.studentService.getStudentById(this.student.getStudentId());
				System.out.println("!!!"+s==null);
				ActionContext.getContext().getSession().put("student", s);
				List<Course> cs=new ArrayList<Course>();
				cs=this.courseService.getCourseByKeywords("前端开发");
				System.out.println("!!!!!!!"+cs.size());
				ActionContext.getContext().put("kcourse", cs);
				ActionContext.getContext().put("Keywords", "前端开发");
				return SUCCESS;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String register(){
		String result = ERROR;
        Student student = studentService.save(this.student);
        result = SUCCESS;
        ActionContext.getContext().getSession().put("student",student);
		return result;
	}

    public String updateStudent(){
        String result = ERROR;
        Student  student = studentService.updateStudent(this.student);
        result = SUCCESS;
        ActionContext.getContext().getSession().put("student",student);
        return result;
    }

    public String getStudentById(){
		String result = SUCCESS;
		Student  student = studentService.getStudentById(this.student.getStudentId());
        //这里先使用session,因为前端页面之前的遗留问题
//		ActionContext.getContext().put("student",student);
        ActionContext.getContext().getSession().put("student",student);
		return result;
	}
	public String showStudents(){
        String result = SUCCESS;
        List<Student> students = studentService.getStudentDao().getStudents();
        ActionContext.getContext().put("students",students);
        return result;
    }

	public String logout(){
		String result = ERROR;
		ActionContext.getContext().getSession().clear();
		result =SUCCESS;
		return result;
	}
//	public String save(){
//		try {
//			if(this.studentService.PersonExists(student)==false){
//				this.studentService.save(student);
//				return SUCCESS;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return ERROR;
//	}
//	public String delete(){
//		try {
//			this.studentService.delete(this.student.getStudentId());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ERROR;
//	}
//	public String update(){
//		try {
//			this.studentService.update(student);
//			return SUCCESS;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ERROR;
//	}
}
