package com.mule.elearing.service;

import com.mule.elearing.dao.CourseDao;
import com.mule.elearing.po.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public List<Course> getCoursesByStudentId(String studentId){
		List<Course> courses  = courseDao.getCourseByStudentId(studentId);
		return courses;
	}


	public void removeStudentCourse(String studentId,String courseId){
        courseDao.removeStudentCourse(studentId,courseId);
    }

    public void saveStudentCourse(String studentId,String courseId,String courseName){
        courseDao.saveStudentCourse(studentId,courseId,courseName);
	}

	public Course getCourse(String courseId){
		Course course=null;
		try {
			course=this.courseDao.get(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	public List<Course> getCourse(){
		List<Course> course=new ArrayList<Course>();
		try {
			course=this.courseDao.getCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	public List<Course> getByPage(int currentPage){
		List<Course> course=new ArrayList<Course>();
		try {
			course=this.courseDao.getByPage(currentPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	public int getTotal(){
		return this.courseDao.getTotal();
	}
	public void Save(Course course){
		this.courseDao.Save(course);
	}
	public void Delete(String courseId){
		this.courseDao.Delete(courseId);
	}
	public void Update(Course course){
		this.courseDao.Update(course);
	}
	public Course getCourseById(String courseId){
		return this.courseDao.getCourseById(courseId);
	}
	public void setTime(Course course){
		this.setTime(course);
	}
	public List<Course> getCourseByKeywords(String keyword){
		List<Course> courses=new ArrayList<Course>();
		courses=this.courseDao.getCourseByKeywords(keyword);
		return courses;
	}
	public List<Course> getCourseByKeywordsOrName(String keyword){
		List<Course> courses=new ArrayList<Course>();
		courses=this.courseDao.getCourseByKeywordsOrName(keyword);
		return courses;
	}
}
