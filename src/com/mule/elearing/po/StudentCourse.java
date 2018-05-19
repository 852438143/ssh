package com.mule.elearing.po;

import javax.persistence.*;

/**
 * Created by 85243 on 2017/4/17.
 */
@Entity
@Table(name = "tb_student_course", schema = "ssh", catalog = "")
@IdClass(StudentCoursePK.class)
public class StudentCourse {
    private String studentId;
    private String courseId;
    private String courseName;
    private String contentId;
    private String contentName;
    private String time;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    public StudentCourse(String studentId, String courseId, String courseName) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public StudentCourse() {
    }

    @Id
    @Column(name = "studentId", nullable = false, length = 50)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "courseId", nullable = false, length = 32)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "courseName", nullable = true, length = 50)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "contentId", nullable = true, length = 32)
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    @Basic
    @Column(name = "contentName", nullable = true, length = 50)
    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    @Basic
    @Column(name = "time", nullable = true, length = 20)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "field1", nullable = true, length = 50)
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Basic
    @Column(name = "field2", nullable = true, length = 50)
    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Basic
    @Column(name = "field3", nullable = true, length = 50)
    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Basic
    @Column(name = "field4", nullable = true, length = 50)
    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    @Basic
    @Column(name = "field5", nullable = true, length = 50)
    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourse that = (StudentCourse) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (contentId != null ? !contentId.equals(that.contentId) : that.contentId != null) return false;
        if (contentName != null ? !contentName.equals(that.contentName) : that.contentName != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (field1 != null ? !field1.equals(that.field1) : that.field1 != null) return false;
        if (field2 != null ? !field2.equals(that.field2) : that.field2 != null) return false;
        if (field3 != null ? !field3.equals(that.field3) : that.field3 != null) return false;
        if (field4 != null ? !field4.equals(that.field4) : that.field4 != null) return false;
        if (field5 != null ? !field5.equals(that.field5) : that.field5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);
        result = 31 * result + (contentName != null ? contentName.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (field1 != null ? field1.hashCode() : 0);
        result = 31 * result + (field2 != null ? field2.hashCode() : 0);
        result = 31 * result + (field3 != null ? field3.hashCode() : 0);
        result = 31 * result + (field4 != null ? field4.hashCode() : 0);
        result = 31 * result + (field5 != null ? field5.hashCode() : 0);
        return result;
    }
}
