package com.hibernatebook.annotations;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class ComputerBook extends Book {

    private String softwareName;

    // Constructors...
    
    protected ComputerBook() {
    }

    public ComputerBook(String title, int pages) {
        super(title, pages);
    }
    
    // Getter

    public String getSoftwareName() {
        return softwareName;
    }
    
    // Setter

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }
}
