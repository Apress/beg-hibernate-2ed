package com.hibernatebook.test.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import com.hibernatebook.spring.Paper;
import com.hibernatebook.spring.dao.ArticleDao;
import com.hibernatebook.spring.dao.PaperDao;

public class TestUtConfig extends AbstractTransactionalSpringContextTests {
	
	private PaperDao localPaperDao;

	public TestUtConfig()
		throws Exception
	{
		if( SimpleNamingContextBuilder.getCurrentContextBuilder() == null ) {
			SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
			DataSource ds = new DriverManagerDataSource("org.hsqldb.jdbcDriver","jdbc:hsqldb:file:/spring/db/springdb;SHUTDOWN=true","sa","");
			
			builder.bind("java:comp/env/jdbc/spring", ds);
			builder.activate();
		}
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] { "akqa.xml" };
	}

	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		localPaperDao = (PaperDao)applicationContext.getBean("paperDao");
	}

	public void testTransaction() {
		PaperDao pdao = (PaperDao)applicationContext.getBean("paperDao");
		List<Paper> list = pdao.getAll();
		list.size();
	}
	
	public void testWrite() {
		PaperDao pdao = (PaperDao)applicationContext.getBean("paperDao");
		pdao.getAll().size();		
		pdao.createPaper(new Paper("A Sample paper"));
	}
	
	public void testMultiBean() {
		PaperDao pdao = (PaperDao)applicationContext.getBean("paperDao");
		ArticleDao adao = (ArticleDao)applicationContext.getBean("articleDao");
		pdao.getAll().size();
		adao.getAll().size();
	}
	
	public void testConfigOnSetup() {
		localPaperDao.getAll().size();
	}	
}
