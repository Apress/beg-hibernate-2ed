package com.hibernatebook.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernatebook.spring.Paper;
import com.hibernatebook.spring.dao.PaperDao;

public class ViewArticlesController implements Controller {
	private PaperDao paperDao;

	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}
	
	public PaperDao getPaperDao() {
		return this.paperDao;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String paperId = request.getParameter("paper");
		Paper paper = getPaperDao().getPaper(Integer.parseInt(paperId));
		return new ModelAndView("viewArticles","paper",paper);
	}
}
