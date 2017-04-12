package com.ylw.dao;

import com.ylw.po.Person;

import java.util.List;

/**
 * Created by 85243 on 2017/4/10.
 */
public interface PersonDao {
    public List<Person> getPersons();
    public Person getPerson(String id);
//    public void delete(String id);
}
