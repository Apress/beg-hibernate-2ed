package com.hibernatebook.spring.form;

public class CreateArticle {
	private Integer paperId;
	private String headline;
	private String byline;
	private String content;

	public Integer getPaperId() {
		return paperId;
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
	
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public void setByline(String byline) {
		this.byline = byline;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
