package com.ylw.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ylw.dao.PersonDao;
import com.ylw.po.Person;

/**
 * Created by 85243 on 2017/4/11.
 */
public class PersonAction extends ActionSupport{
    private PersonDao personDao;
    private Person person;
    public String list(){
        person = personDao.getPerson("2");
        System.out.println(person);
        return "success";
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
