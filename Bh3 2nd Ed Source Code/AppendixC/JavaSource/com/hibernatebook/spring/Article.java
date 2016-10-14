package com.hibernatebook.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	private Integer id;
	private String headline;
	private String byline;	
	private String content;
	
	public Article(String headline, String byline, String content) {
		this.headline = headline;
		this.byline = byline;
		this.content = content;
	}
	
	protected Article() {
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public String getHeadline() {
		return headline;
	}

	public String getByline() {
		return byline;
	}

	public String getContent() {
		return content;
	}

	protected void setId(Integer id) {
		this.id = id;
	}
	
	protected void setHeadline(String headline) {
		this.headline = headline;
	}

	protected void setByline(String byline) {
		this.byline = byline;
	}

	protected void setContent(String content) {
		this.content = content;
	}
}
