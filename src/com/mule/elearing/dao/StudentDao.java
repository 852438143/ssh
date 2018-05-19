package com.mule.elearing.dao;

import com.mule.elearing.po.Course;
import com.mule.elearing.po.Person;
import com.mule.elearing.po.Student;

import java.util.List;

/**
 * Created by 85243 on 2017/4/10.
 */
public interface StudentDao {
    public List<Student> getStudents();
    public Person getStudent(String id);
    public boolean StudentExists(Student tudent);
    public List<Course> getCourse(String studentId);
    public Student getStudentById(String studentId);
    public void save(Student student);
    public void updateStudent(Student student);
//    public void delete(String id);
}
