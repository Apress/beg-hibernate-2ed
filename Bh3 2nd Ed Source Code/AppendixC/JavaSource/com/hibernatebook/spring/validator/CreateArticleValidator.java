package com.hibernatebook.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hibernatebook.spring.form.CreateArticle;

public class CreateArticleValidator implements Validator {
	public boolean supports(Class type) {
		return CreateArticle.class.equals(type);
	}

	public void validate(Object command, Errors errors) {
		CreateArticle form = (CreateArticle)command;
		System.out.println("CreateArticleValidator");
		if( ( form.getHeadline() == null ) || form.getHeadline().trim().equals("") ) {
			System.out.println("headline: " + form.getHeadline());
			errors.rejectValue("headline","createArticle.headline.empty");
		}
		
		if( ( form.getByline() == null ) || form.getByline().trim().equals("") ) {
			System.out.println("byline: " + form.getByline());
			errors.rejectValue("byline","createArticle.byline.empty");
		}

		if( ( form.getContent() == null ) || form.getContent().trim().equals("") ) {
			System.out.println("content: " + form.getContent());
			errors.rejectValue("content","createArticle.content.empty");
		}
	}
}
