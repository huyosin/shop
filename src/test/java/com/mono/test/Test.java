package com.mono.test;

import static org.junit.Assert.fail;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.shiro.crypto.hash.Sha256Hash;
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
		Sha256Hash s = new Sha256Hash("liuliang","1");
		Random random = new SecureRandom();
		log.debug(random.nextInt()+"");
		log.debug(s.toString());
		log.trace("======trace");  
        log.debug("======debug");  
        log.info("======info");  
        log.warn("======warn");  
        log.error("======error"); 
		fail("Not yet implemented");
	}

}
