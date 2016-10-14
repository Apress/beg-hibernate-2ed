package com.hibernatebook.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernatebook.spring.Article;
import com.hibernatebook.spring.Paper;

// TODO: Session handling frigged for testing
public class PaperDaoImpl 
	extends HibernateDaoSupport 
	implements PaperDao 
{	

	@SuppressWarnings("unchecked")
	public List<Paper> getAll() {
		Session session = getSession();
		List<Paper> papers = (List<Paper>)session.createQuery("from Paper").list();
		return papers;
	}
	
	public void createPaper(final Paper paper) {
		Session session = getSession();
		session.save(paper);
	}
	
	public Paper getPaper(final Integer paperId) {
		Session session = getSession();
		return (Paper)session.get(Paper.class,paperId);
	}
	
	public Paper createArticle(final Integer paperId,final Article article) {
		Session session = getSession();
		Paper paper = (Paper)session.get(Paper.class,paperId);
		paper.addArticle(article);
		session.update(paper);
		return paper;				
	}
}
