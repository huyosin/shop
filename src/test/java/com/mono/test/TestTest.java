package com.mono.test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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

import com.baomidou.mybatisplus.plugins.Page;
import com.mono.core.service.TestService;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-core.xml")
public class TestTest {
	private static Logger logger = LoggerFactory.getLogger(TestTest.class);
	static{  
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();  
        JoranConfigurator configurator = new JoranConfigurator();  
        configurator.setContext(lc);  
        lc.reset();  
        try {  
            configurator.doConfigure("C:/work/workspace/eclipse_workspace_MonO/shop/src/main/resources/logback.xml");//加载logback配置文件  
       } catch (JoranException e) {  
            e.printStackTrace();  
        } 
    }  
	
	@Resource
	private TestService testService;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// //@Test
	// public void test() {
	// com.mono.core.entity.Test test = testDao.get(1);
	// Assert.assertEquals("sx", test.getName());
	// log.debug("name:" + test.getName());
	//
	// log.debug(NamedParameterUtils.parseSqlStatement("insert into test
	// values(:{id},:{name})").toString());
	// }
	//
	// //@Test
	// public void testAdd() {
	// com.mono.core.entity.Test test = new com.mono.entity.Test();
	// test.setName("4name");
	// log.debug("id是:"+test.getId());
	// int key = testDao.add(test);
	// log.debug("主键是:"+key);
	// Assert.assertTrue(key > 0);
	// }
	//
	// //@Test
	// public void testUpdate() {
	// com.mono.core.entity.Test test = new com.mono.entity.Test();
	// test.setId(5);
	// test.setName("new5");
	// int value = testDao.update(test);
	// Assert.assertTrue(value > 0);
	// }
	//
	// //@Test
	// public void testDelete() {
	// Map<String,Object> paramMap = new HashMap<String,Object>();
	// paramMap.put("id", 5);
	// paramMap.put("name", "new5");
	// int key = testDao.delete(paramMap);
	// Assert.assertTrue(key > 0);
	// }
	//
	// //@Test
	// public void testGetAll(){
	// List<com.mono.core.entity.Test> result = testDao.getAll();
	// for(com.mono.core.entity.Test test: result){
	// log.debug(test.getId() + ": " + test.getName());
	// }
	// }

	// @Test
	// public void testQuery(){
	// Page<com.mono.core.entity.Test> page = new Page<com.mono.entity.Test>();
	// QueryHelper queryHelper = new QueryHelper();
	// page = testService.query(page, queryHelper);
	// log.debug(page.toString());
	// for(com.mono.entity.core.Test test: page.getElements()){
	// log.debug(test.getId() + ": " + test.getName());
	// }
	// }

	// @Test
	// public void testController(){
	// testController.query(1,new RedirectAttributesModelMap());
	// }

	@Test
	public void testService() {
		Page<com.mono.core.entity.Test> page = new Page<com.mono.core.entity.Test>();
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("name", "1");
		condition.put("createdateStart", "2017-06-19");
		page.setOrderByField("id");
		page.setAsc(false);
		page.setCondition(condition);
		page = testService.selectPerPage(page);
		System.out.println(page.getRecords());
		
//		com.mono.core.entity.Test test = new com.mono.core.entity.Test();
//		test.setName("sxname");
//		test.setDate(new Date());
//		test.setMdate(new Date());
//		testService.insert(test);
//		test = testService.selectTestByName("sxname").get(0);
//		System.out.println(test);
	}

}
