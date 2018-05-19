package com.mule.elearing.service;

import com.mule.elearing.dao.StudentDao;
import com.mule.elearing.po.Student;
import com.mule.elearing.po.Course;

import java.util.ArrayList;
import java.util.List;


public class StudentService {
	private StudentDao studentDao;
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public boolean StudentExists(Student student){
		//System.out.println(student==null);
		return this.studentDao.StudentExists(student);
		//return false;
	}
	public List<Course> getCourses(String studentId){
		List<Course> courses=new ArrayList<Course>();
		courses=this.studentDao.getCourse(studentId);
		return courses;
	}


	public Student save(Student student){
		Student stu = new Student();
		if(!studentDao.StudentExists(student)){
			studentDao.save(student);
		}
		stu = studentDao.getStudentById(student.getStudentId());
		return stu;
	}

	public Student updateStudent(Student student){
		Student stu = new Student();
		studentDao.updateStudent(student);
		stu = studentDao.getStudentById(student.getStudentId());
		return stu;
	}

	public List<Student> getStudents(){
		List<Student> students = studentDao.getStudents();
		return students;
	}

	public Student getStudentById(String studentId){
		return this.studentDao.getStudentById(studentId);
	}
}
