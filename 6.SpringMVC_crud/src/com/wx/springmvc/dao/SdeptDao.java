package com.wx.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wx.springmvc.bean.Sdept;

@Repository
public class SdeptDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Sdept> getAllSdept(){
		String sql = "select * from sdept";
		List<Sdept> sdepts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sdept>(Sdept.class));
		return sdepts;
	}
}
