package com.journaldev.spring.controller;

import java.util.Date;

import org.springframework.stereotype.Repository;
@Repository
public class HelloDaoImpl implements HelloDao {

	public String getTime() {
		String date  = new Date().toString();
		return date;
	}

}
