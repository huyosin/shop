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

import com.mono.core.entity.vo.TreeVo;
import com.mono.core.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-core.xml")
public class MenuTest {
	private static Logger logger = LoggerFactory.getLogger(MenuTest.class);
//	@Resource
//	private SessionFactory sessionFactory;
	
	@Resource
	private MenuService menuService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
//		Session s = sessionFactory.openSession();
//		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
	}

	@After
	public void tearDown() throws Exception {
//		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
//		Session s = holder.getSession(); 
//		s.flush();
//		TransactionSynchronizationManager.unbindResource(sessionFactory);
	}

	@Test
	public void test() throws Exception {
		 List<TreeVo> menuTrees = menuService.getMenuTreeByLoginName("liuliang");
		 logger.debug("menus:" + menuTrees);
	}

}
