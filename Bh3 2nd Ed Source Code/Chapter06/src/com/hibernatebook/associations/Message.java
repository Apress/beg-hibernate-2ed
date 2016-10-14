package com.hibernatebook.associations;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Message {
    
    public Message() {
    }
    
    public Message(String title) {
        this.content = title;
    }
    
    private Integer id;
    
    
    private String content;
    
    private Email email;

    @OneToOne(mappedBy="message",optional=true)
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String toString() {
        return getContent();
    }
}
