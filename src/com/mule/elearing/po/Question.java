package com.mule.elearing.po;

import javax.persistence.*;

/**
 * Created by 85243 on 2017/4/17.
 */
@Entity
@Table(name = "tb_question", schema = "ssh", catalog = "")
public class Question {
    private String questionId;
    private String courseId;
    private String content;
    private String answer;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    @Id
    @Column(name = "questionId", nullable = false, length = 32)
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "answer", nullable = true, length = 5)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

        Question that = (Question) o;

        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (field1 != null ? !field1.equals(that.field1) : that.field1 != null) return false;
        if (field2 != null ? !field2.equals(that.field2) : that.field2 != null) return false;
        if (field3 != null ? !field3.equals(that.field3) : that.field3 != null) return false;
        if (field4 != null ? !field4.equals(that.field4) : that.field4 != null) return false;
        if (field5 != null ? !field5.equals(that.field5) : that.field5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId != null ? questionId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (field1 != null ? field1.hashCode() : 0);
        result = 31 * result + (field2 != null ? field2.hashCode() : 0);
        result = 31 * result + (field3 != null ? field3.hashCode() : 0);
        result = 31 * result + (field4 != null ? field4.hashCode() : 0);
        result = 31 * result + (field5 != null ? field5.hashCode() : 0);
        return result;
    }
}
