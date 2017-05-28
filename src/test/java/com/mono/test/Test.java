package com.mono.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static Logger log = LoggerFactory.getLogger(Test.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@org.junit.Test
	public void test() {
		log.trace("======trace");  
        log.debug("======debug");  
        log.info("======info");  
        log.warn("======warn");  
        log.error("======error"); 
		fail("Not yet implemented");
	}

}
