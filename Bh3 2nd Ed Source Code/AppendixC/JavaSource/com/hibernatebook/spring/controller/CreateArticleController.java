package com.hibernatebook.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.hibernatebook.spring.Article;
import com.hibernatebook.spring.Paper;
import com.hibernatebook.spring.dao.PaperDao;
import com.hibernatebook.spring.form.CreateArticle;

public class CreateArticleController extends SimpleFormController {
	
	private PaperDao paperDao;
	
	@Override
	protected ModelAndView onSubmit(Object command) {
		CreateArticle form = (CreateArticle)command;
		Integer paperId = form.getPaperId();
		Article article = new Article(
				form.getHeadline(),
				form.getByline(),
				form.getContent());
		Paper paper = getPaperDao().createArticle(paperId,article);
		return new ModelAndView(getSuccessView(),"paper",paper);
	}

	public PaperDao getPaperDao() {
		return paperDao;
	}

	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}

	@Override
	protected void onBindOnNewForm(HttpServletRequest request, Object command) throws Exception {
		CreateArticle form = (CreateArticle)command;
		Paper paper = getPaperDao().getPaper(form.getPaperId());
		request.setAttribute("paper",paper);
	}

	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors) throws Exception {
		CreateArticle form = (CreateArticle)command;
		Paper paper = getPaperDao().getPaper(form.getPaperId());
		request.setAttribute("paper",paper);
	}

}
