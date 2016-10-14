package com.hibernatebook.tools;

public class Privat {
	private int id;
	private String message;
	
	private Privat() {
	}
	
	public Privat(String message) {
		this.message = message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		return this.message;
	}
	
}
