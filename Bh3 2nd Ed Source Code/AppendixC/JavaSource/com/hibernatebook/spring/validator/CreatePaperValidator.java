package com.hibernatebook.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hibernatebook.spring.form.CreatePaper;

public class CreatePaperValidator implements Validator {

	public boolean supports(Class type) {
		return CreatePaper.class.equals(type);
	}

	public void validate(Object command, Errors errors) {
		System.out.println("CreatePaperValidator");
		CreatePaper form = (CreatePaper)command;
		if( (form.getTitle() == null) || 
			 form.getTitle().trim().equals("") ) {
			errors.rejectValue("title","createPaper.title.empty");
		}
	}
}
