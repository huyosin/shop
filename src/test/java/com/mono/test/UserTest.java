package com.mono.test;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mono.core.entity.User;
import com.mono.core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-core.xml")
public class UserTest {
	private static Logger log = LoggerFactory.getLogger(UserTest.class);
	
	@Resource
	private UserService userService;

	@BeforeClass
	public static void setUpBeforeClass(){}

	@AfterClass
	public static void tearDownAfterClass(){}

	@Before
	public void setUp(){
	}

	@After
	public void tearDown(){
	}

	@Test
	public void test(){
		if(userService == null){
			log.debug("userService:null");
		}
		User user = userService.getUserByLoginName("liuliang");
		if(user == null){
			log.debug("user:null");
		}else{
			log.debug("userid:" + user.getId() + "loginName:" + user.getLoginName());
		}
	}
}
