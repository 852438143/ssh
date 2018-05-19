package com.mule.elearing.action;

import com.mule.elearing.dao.PersonDao;
import com.mule.elearing.service.PersonService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.mule.elearing.po.Person;

/**
 * Created by 85243 on 2017/4/11.
 */
@Component("personAction")
@Scope("prototype")
public class PersonAction extends ActionSupport implements ModelDriven{
    private PersonDao personDao;
    private Person person=new Person();
    private PersonService personService;
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
    
   
	

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}


	public PersonDao getPersonDao() {
		return personDao;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return person;
	}
	
	public String login(){
		System.out.println(person.getId());
		try {
			System.out.println(this.personService.PersonExists(this.person)==true);
			if(this.personService.PersonExists(this.person))return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
