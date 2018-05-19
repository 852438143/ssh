package com.mule.elearing.po;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 85243 on 2017/4/17.
 */
@Entity
@Table(name = "tb_course", schema = "ssh", catalog = "")
public class Course {
    private String courseId;
    private String courseName;
    private String introduction;
    private Integer studentNum;
    private String teacher;
    private String level;
    private String startTime;
    private String keyword;
    private String picUrl;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private Set<Content> tbContentByCourseId;

    @Id
    @GeneratedValue
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
    @Column(name = "introduction", nullable = true, length = -1)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "studentNum", nullable = true)
    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    @Basic
    @Column(name = "teacher", nullable = true, length = 10)
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "level", nullable = true, length = 10)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "startTime", nullable = true, length = 20)
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "keyword", nullable = true, length = 20)
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "picUrl", nullable = true, length = 50)
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

        Course that = (Course) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (introduction != null ? !introduction.equals(that.introduction) : that.introduction != null) return false;
        if (studentNum != null ? !studentNum.equals(that.studentNum) : that.studentNum != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (picUrl != null ? !picUrl.equals(that.picUrl) : that.picUrl != null) return false;
        if (field1 != null ? !field1.equals(that.field1) : that.field1 != null) return false;
        if (field2 != null ? !field2.equals(that.field2) : that.field2 != null) return false;
        if (field3 != null ? !field3.equals(that.field3) : that.field3 != null) return false;
        if (field4 != null ? !field4.equals(that.field4) : that.field4 != null) return false;
        if (field5 != null ? !field5.equals(that.field5) : that.field5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (studentNum != null ? studentNum.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (field1 != null ? field1.hashCode() : 0);
        result = 31 * result + (field2 != null ? field2.hashCode() : 0);
        result = 31 * result + (field3 != null ? field3.hashCode() : 0);
        result = 31 * result + (field4 != null ? field4.hashCode() : 0);
        result = 31 * result + (field5 != null ? field5.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "content")
    public Set<Content> getTbContentByCourseId() {
        return tbContentByCourseId;
    }

    public void setTbContentByCourseId(Set<Content> tbContentByCourseId) {
        this.tbContentByCourseId = tbContentByCourseId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", studentNum=" + studentNum +
                ", teacher='" + teacher + '\'' +
                ", level='" + level + '\'' +
                ", startTime='" + startTime + '\'' +
                ", keyword='" + keyword + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                ", tbContentByCourseId=" + tbContentByCourseId +
                '}';
    }
}
