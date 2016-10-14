package com.hibernatebook.tools;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Notepad {
	private String owner;
	private Integer id;
	private List<Note> notes;
	
	public Notepad(String owner) {
		this.owner = owner;
		this.notes = new ArrayList<Note>();
	}
	
	protected Notepad() {
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	@OneToMany(cascade={ALL})
	public List<Note> getNotes() {
		return this.notes;
	}
	
	protected void setId(Integer id) {
		this.id = id;
	}
	 
	protected void setOwner(String owner) {
		this.owner = owner;
	}
	
	protected void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public void addNote(String note) {
		this.getNotes().add(new Note(note));
	}
	
	public String toString() {
		return this.owner + "'s Notepad.";
	}
}
