package com.mule.elearing.dao;

import com.mule.elearing.po.Person;

import java.util.List;

/**
 * Created by 85243 on 2017/4/10.
 */
public interface PersonDao {
    public List<Person> getPersons();
    public Person getPerson(String id);
    public boolean PersonExists(Person person);
//    public void delete(String id);
}
