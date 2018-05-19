package com.mule.elearing.dao;

import com.mule.elearing.po.Course;

import java.util.List;

public interface CourseDao {
	public Course get(String courseId);

	public List<Course> getCourseByStudentId(String studentdi);
	public List<Course> getCourse();
	public int getTotal();
	public List<Course> getByPage(int currentPage);
	public void Save(Course course);
	public void Delete(String courseId);
	public void Update(Course course);
	public Course getCourseById(String courseId);
	public void setTime(Course course);
	public List<Course> getCourseByKeywords(String keyword);
	public List<Course> getCourseByKeywordsOrName(String keyword);

	public void removeStudentCourse(String studentId,String courseId);

	public void saveStudentCourse(String studentId,String courseId,String courseName);
}
