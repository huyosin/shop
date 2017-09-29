package com.mono.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static Logger logger = LoggerFactory.getLogger(Test.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {}

	@After
	public void tearDown() throws Exception {}

	@org.junit.Test
	public void test() throws ParseException {
//		Random random = new SecureRandom();
//		Integer salt = random.nextInt();
//		log.debug(salt+"");
//		String s = new Sha256Hash("liuliang","liuliang"+salt.toString(),3).toHex();
//		log.debug(s);
//		log.trace("======trace");  
//        log.debug("======debug");  
//        log.info("======info");  
//        log.warn("======warn");  
//        log.error("======error"); 
//		fail("Not yet implemented");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date date2 = format.parse("2018-07-27");
		System.out.println(date.compareTo(date2));
	}

}
