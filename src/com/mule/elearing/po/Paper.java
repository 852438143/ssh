package com.mule.elearing.po;

import javax.persistence.*;

/**
 * Created by 85243 on 2017/4/17.
 */
@Entity
@Table(name = "tb_paper", schema = "ssh", catalog = "")
public class Paper {
    private String paperId;
    private String studentId;
    private String courseId;
    private String questionIds;
    private String result;
    private String score;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    @Id
    @Column(name = "paperId", nullable = false, length = 32)
    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    @Basic
    @Column(name = "studentId", nullable = true, length = 50)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "courseId", nullable = true, length = 32)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "questionIds", nullable = true, length = -1)
    public String getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
    }

    @Basic
    @Column(name = "result", nullable = true, length = 255)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "score", nullable = true, length = 5)
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

        Paper that = (Paper) o;

        if (paperId != null ? !paperId.equals(that.paperId) : that.paperId != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (questionIds != null ? !questionIds.equals(that.questionIds) : that.questionIds != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (field1 != null ? !field1.equals(that.field1) : that.field1 != null) return false;
        if (field2 != null ? !field2.equals(that.field2) : that.field2 != null) return false;
        if (field3 != null ? !field3.equals(that.field3) : that.field3 != null) return false;
        if (field4 != null ? !field4.equals(that.field4) : that.field4 != null) return false;
        if (field5 != null ? !field5.equals(that.field5) : that.field5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = paperId != null ? paperId.hashCode() : 0;
        result1 = 31 * result1 + (studentId != null ? studentId.hashCode() : 0);
        result1 = 31 * result1 + (courseId != null ? courseId.hashCode() : 0);
        result1 = 31 * result1 + (questionIds != null ? questionIds.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (score != null ? score.hashCode() : 0);
        result1 = 31 * result1 + (field1 != null ? field1.hashCode() : 0);
        result1 = 31 * result1 + (field2 != null ? field2.hashCode() : 0);
        result1 = 31 * result1 + (field3 != null ? field3.hashCode() : 0);
        result1 = 31 * result1 + (field4 != null ? field4.hashCode() : 0);
        result1 = 31 * result1 + (field5 != null ? field5.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId='" + paperId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", questionIds='" + questionIds + '\'' +
                ", result='" + result + '\'' +
                ", score='" + score + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }
}
