package com.mule.elearing.po;

import java.util.Date;

/**
 * Created by 85243 on 2017/4/10.
 */
public class Person {
    private String id;
    private String name;
    private Date birthday;
    private String aid;

    public Person() {
    }

    public Person(String id, String name, Date birthday, String aid) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.aid = aid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "PersonAction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", aid='" + aid + '\'' +
                '}';
    }
}
