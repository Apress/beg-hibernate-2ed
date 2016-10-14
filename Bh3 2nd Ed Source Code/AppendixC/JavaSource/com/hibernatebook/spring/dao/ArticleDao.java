package com.hibernatebook.spring.dao;

import java.util.List;

import com.hibernatebook.spring.Article;

public interface ArticleDao {
	public List<Article> getAll();		
	public Article getArticle(final Integer articleId);
}
