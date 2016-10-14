package com.hibernatebook.tools;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Note {
	
	private String note;
	private Integer id;
	
	protected Note() {
	}
	
	Note(String note) {
		this.note = note;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public String getNote() {
		return note;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected void setNote(String note) {
		this.note = note;
	}
	
	public String toString() {
		return "Note: " + this.note;
	}
}
