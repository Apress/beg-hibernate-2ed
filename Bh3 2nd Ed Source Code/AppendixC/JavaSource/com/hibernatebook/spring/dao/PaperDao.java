package com.hibernatebook.spring.dao;

import java.util.List;

import com.hibernatebook.spring.Article;
import com.hibernatebook.spring.Paper;

public interface PaperDao {
	public List<Paper> getAll();		
	public void createPaper(final Paper paper);
	public Paper getPaper(final Integer paperId);
	public Paper createArticle(final Integer paperId,final Article article);
}
