package com.wx.springmvc.bean;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {
	
	private String id;
	@NotEmpty
	private String lastName;
	@Max(value = 30)
	@Min(value = 18,message = "年龄不可小于18")
	private Integer age;
	/*
	 * hibernate validator需要导入五个包
	 * classmate-1.0.0.jar
		hibernate-validator-5.1.0.Final.jar
		hibernate-validator-annotation-processor-5.1.0.Final.jar
		jboss-logging-3.1.3.GA.jar
		validation-api-1.1.0.Final.jar
	 */
	@Email
	private String email;
	//日期格式化
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	@JsonIgnore
	private Integer sdeptId;
	public Person() {
		super();
	}
	
	public Person(String id, String lastName, Integer age, String email, Date birth, Integer sdeptId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.birth = birth;
		this.sdeptId = sdeptId;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getSdeptId() {
		return sdeptId;
	}
	public void setSdeptId(Integer sdeptId) {
		this.sdeptId = sdeptId;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", age=" + age + ", email=" + email + ", birth=" + birth
				+ ", sdeptId=" + sdeptId + "]";
	}
	
	
}
