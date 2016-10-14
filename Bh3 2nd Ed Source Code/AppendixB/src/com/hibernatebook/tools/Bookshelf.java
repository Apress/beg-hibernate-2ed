package com.hibernatebook.tools;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
	private Integer id;
	private String category;
	private List<Notepad> notepads;
	
	public Bookshelf(String category) {
		this.category = category;
		notepads = new ArrayList<Notepad>();
	}
	
	protected Bookshelf() {
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public List<Notepad> getNotepads() {
		return this.notepads;
	}
	
	protected void setId(Integer id) {
		this.id = id;
	}
	
	protected void setCategory(String category) {
		this.category = category;
	}
	
	protected void setNotepads(List<Notepad> notepads) {
		this.notepads = notepads;
	}
	
	public void addNotepad(Notepad notepad) {
		this.getNotepads().add(notepad);
	}
}
