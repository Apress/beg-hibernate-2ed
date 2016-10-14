package com.hibernatebook.spring;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paper {
	private Integer id = null;
	private String title = null;
	private Set<Article> articles = null;
	
	public Paper(String title) {
		this.title = title;
		this.articles = new HashSet<Article>();
	}
	
	protected Paper() {
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}

	@OneToMany(cascade=ALL,fetch=LAZY)
	public Set<Article> getArticles() {
		return articles;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	protected void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article article) {
		this.getArticles().add(article);
	}
}
