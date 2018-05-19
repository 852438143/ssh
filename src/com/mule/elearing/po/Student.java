package com.mule.elearing.po;

import javax.persistence.*;

/**
 * Created by 85243 on 2017/4/17.
 */
@Entity
@Table(name = "tb_student", schema = "ssh", catalog = "")
public class Student {
    private String studentId;
    private String studentName;
    private String postion;
    private String email;
    private String tel;
    private String keyword;
    private String password;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    @Id
    @Column(name = "studentId", nullable = false, length = 50)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "studentName", nullable = true, length = 10)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "postion", nullable = true, length = 20)
    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 11)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
    @Column(name = "password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        Student that = (Student) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (postion != null ? !postion.equals(that.postion) : that.postion != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (field2 != null ? !field2.equals(that.field2) : that.field2 != null) return false;
        if (field3 != null ? !field3.equals(that.field3) : that.field3 != null) return false;
        if (field4 != null ? !field4.equals(that.field4) : that.field4 != null) return false;
        if (field5 != null ? !field5.equals(that.field5) : that.field5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (postion != null ? postion.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (field2 != null ? field2.hashCode() : 0);
        result = 31 * result + (field3 != null ? field3.hashCode() : 0);
        result = 31 * result + (field4 != null ? field4.hashCode() : 0);
        result = 31 * result + (field5 != null ? field5.hashCode() : 0);
        return result;
    }
}
