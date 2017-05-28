package com.mono.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.mono.core.entity.Menu;
import com.mono.core.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-core.xml")
public class MenuTest {
	private static Logger log = LoggerFactory.getLogger(MenuTest.class);
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private MenuService menuService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
	}

	@After
	public void tearDown() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	}

	@Test
	public void test() throws Exception {
		List<Menu> menus = menuService.getTopMenuByLoginname("liuliang");
		for (Menu menu : menus) {
			log.debug("menu:" + menu);
		}
		Assert.assertTrue(menus.size() > 0);
		// List<Menu> menus = menuService.getAllById(new Long(1));
		// log.debug("menus:" + menus);
	}

}
