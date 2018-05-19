package com.mule.elearing.service;

import com.mule.elearing.dao.PersonDao;
import com.mule.elearing.po.Person;


public class PersonService {
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public boolean PersonExists(Person person){
		System.out.println(person==null);
		return this.personDao.PersonExists(person);
		//return false;
	}
	
	
}
