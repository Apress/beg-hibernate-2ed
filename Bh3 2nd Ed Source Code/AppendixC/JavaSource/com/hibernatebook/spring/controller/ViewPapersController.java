package com.hibernatebook.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hibernatebook.spring.dao.PaperDao;

public class ViewPapersController implements Controller {
	
	private PaperDao paperDao;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("viewPapers","papers",getPaperDao().getAll());
	}
	
	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}
	
	public PaperDao getPaperDao() {
		return this.paperDao;
	}

}
