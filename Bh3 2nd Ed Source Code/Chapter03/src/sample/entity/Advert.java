package sample.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Advert {
   private long id;
   private String title;
   private String message;
   private User user;
   private Set<Category> categories;

   public Advert(String title, String message, User user) {
      this.title = title;
      this.message = message;
      this.user = user;
      this.categories = new HashSet<Category>();
   }

   Advert() {
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   @ManyToOne
   @JoinColumn(name="aduser")
   public User getUser() {
           return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   @ManyToMany(mappedBy="adverts")
   public Set<Category> getCategories() {
       return categories;
   }

   public void setCategories(Set<Category> categories) {
       this.categories = categories;
   }

   @Id
   @GeneratedValue
   protected long getId() {
      return id;
   }

   protected void setId(long id) {
      this.id = id;
   }
}