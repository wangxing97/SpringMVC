package com.wx.springmvc.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wx.springmvc.bean.Person;
import com.wx.springmvc.dao.PersonDao;

class SpringMVCTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("springmvc.xml");
	
	@Test
	void test() {
		PersonDao personDao = ioc.getBean(PersonDao.class);
		/*int addPerson = personDao.addPerson(new Person(null, "王天顺", 22, 103));
		System.out.println(addPerson);*/
		/*List<Person> selAllPerson = personDao.selAllPerson();
		for (Person person : selAllPerson) {
			System.out.println(person);
		}*/
		//personDao.deletePerson(1004);
		List<Person> selAllPerson = personDao.selAllPerson();
		/*for (Person person : selAllPerson) {
			System.out.println(person);
		}*/
	}

}
