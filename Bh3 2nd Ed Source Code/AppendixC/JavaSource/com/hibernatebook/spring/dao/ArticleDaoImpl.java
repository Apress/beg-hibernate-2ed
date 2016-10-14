package com.hibernatebook.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernatebook.spring.Article;

public class ArticleDaoImpl 
	extends HibernateDaoSupport 
	implements ArticleDao 
{

	@SuppressWarnings("unchecked")
	public List<Article> getAll() {
		Session session = getSession();
		List<Article> articles = (List<Article>)session.createQuery("from Article").list();
		return articles;		
	}

	public Article getArticle(Integer articleId) {
		Session session = getSession();
		return (Article)session.get(Article.class,articleId);
	}
}
