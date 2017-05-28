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

import com.mono.core.service.TestService;
import com.mono.core.util.hibernate.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-core.xml")
public class TestTest {
	private static Logger log = LoggerFactory.getLogger(TestTest.class);
	@Resource
	private TestService testService;
//	@Resource
//	private TestController testController;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {}

//	//@Test
//	public void test() {
//		com.mono.entity.Test test = testDao.get(1);
//		Assert.assertEquals("sx", test.getName());
//		log.debug("name:" + test.getName());
//		
//		log.debug(NamedParameterUtils.parseSqlStatement("insert into test values(:{id},:{name})").toString());
//	}
//	
//	//@Test
//	public void testAdd() {
//		com.mono.entity.Test test = new com.mono.entity.Test();
//		test.setName("4name");
//		log.debug("id是:"+test.getId());
//		int key = testDao.add(test);
//		log.debug("主键是:"+key);
//		Assert.assertTrue(key > 0);
//	}	
//	
//	//@Test
//	public void testUpdate() {
//		com.mono.entity.Test test = new com.mono.entity.Test();
//		test.setId(5);
//		test.setName("new5");
//		int value = testDao.update(test);
//		Assert.assertTrue(value > 0);
//	}
//	
//	//@Test
//	public void testDelete() {
//		Map<String,Object> paramMap = new HashMap<String,Object>();
//		paramMap.put("id", 5);
//		paramMap.put("name", "new5");
//		int key = testDao.delete(paramMap);
//		Assert.assertTrue(key > 0);
//	}
//	
//	//@Test
//	public void testGetAll(){
//		List<com.mono.entity.Test> result = testDao.getAll();
//		for(com.mono.entity.Test test: result){
//			log.debug(test.getId() + ": " + test.getName());
//		}
//	}
	
//	@Test
//	public void testQuery(){
//		Page<com.mono.entity.Test> page = new Page<com.mono.entity.Test>();
//		QueryHelper queryHelper = new QueryHelper();
//		page = testService.query(page, queryHelper);
//		log.debug(page.toString());
//		for(com.mono.entity.Test test: page.getElements()){
//			log.debug(test.getId() + ": " + test.getName());
//		}
//	}
	
//	@Test
//	public void testController(){
//		testController.query(1,new RedirectAttributesModelMap());
//	}
	
	@Test
	public void testService(){
		Page<com.mono.core.entity.Test> page = testService.getAllPerPage(1);
	}

}
