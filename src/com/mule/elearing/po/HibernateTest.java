//package com.mule.elearing.po;
//
//import javax.persistence.*;
//import java.util.Set;
//
///**
// * Created by 85243 on 2017/7/4.
// */
//@Entity
//@Table(name= "tb_hibernateTest")
//public class HibernateTest {
//    private String hibernateId;
//
//
//    private String firstName;
//
//    private Set<Comment> comments;
//
//
//    @Id
//    @GeneratedValue
//    @Column(name = "hibernateId", nullable = false, length = 32)
//    public String getHibernateId() {
//        return hibernateId;
//    }
//
//    public void setHibernateId(String hibernateId) {
//        this.hibernateId = hibernateId;
//    }
//
//
//
//    @Basic
//    @Column(name = "firstName", nullable = true, length = 50)
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @OneToMany
//    public Set<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(Set<Comment> comments) {
//        this.comments = comments;
//    }
//}
