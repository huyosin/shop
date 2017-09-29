package com.mono.test;


import java.util.List;

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

import com.mono.core.entity.Operation;
import com.mono.core.service.OperationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-core.xml")
public class OperationTest {
	private static Logger log = LoggerFactory.getLogger(OperationTest.class);
	
	@Resource
	private OperationService operationService;

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
		List<Operation> operations = operationService.getOperationByLoginName("liuliang");
		log.debug(operations.toString());
	}
}
