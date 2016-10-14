package com.hibernatebook.spring.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hibernatebook.spring.Paper;
import com.hibernatebook.spring.dao.PaperDao;
import com.hibernatebook.spring.form.CreatePaper;

public class CreatePaperController extends SimpleFormController {
	
	private PaperDao paperDao;
	
	protected ModelAndView onSubmit(Object command) {
		CreatePaper form = (CreatePaper)command;
		paperDao.createPaper(new Paper(form.getTitle()));
		return new ModelAndView(getSuccessView(),"papers",getPaperDao().getAll());
	}

	public PaperDao getPaperDao() {
		return paperDao;
	}

	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}
}
