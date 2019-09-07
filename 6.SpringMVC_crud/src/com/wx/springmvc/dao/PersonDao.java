package com.wx.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wx.springmvc.bean.Person;

@Repository
public class PersonDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * 查询所有人
	 */
	public List<Person> selAllPerson(){
		//System.out.println("------"+jdbcTemplate);
		String sql = "select * from person";
		List<Person> persons = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Person>(Person.class));
		return persons;
	}
	/*
	 * 修改某人
	 */
	public void updatePerson(Person person) {
		String sql = "update person set age = ?,email = ?,birth = ?,sdeptId = ? where id = ?";
		int update = jdbcTemplate.update(sql,person.getAge(),person.getEmail(),person.getBirth(),person.getSdeptId(),person.getId());
	}
	/*
	 * 增加某人
	 */
	public int addPerson(Person person) {
		String sql = "insert into person(lastName,age,email,birth,sdeptId) values(?,?,?,?,?)";
		int result = jdbcTemplate.update(sql, person.getLastName(),person.getAge(),person.getEmail(),person.getBirth(),person.getSdeptId());
		return result;
	}
	/*
	 * 删除某人
	 */
	public int deletePerson(Integer id) {
		String sql = "delete from person where id = ?";
		int result = jdbcTemplate.update(sql,id);
		return result;
	}
	/*
	 * 获取某人
	 */
	public Person getPerson(Integer id) {
		String sql = "select * from person where id = ?";
		Person person = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Person>(Person.class), id);
		return person;
	}
}
