package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
	@Autowired
	private HelloDao helloDao;
	

	public HelloDao getHelloDao() {
		return helloDao;
	}


	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}


	public String getTime() {
		 
		String date  = helloDao.getTime();
		return date;
	}

}
