package sample.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {
   private long id;
   private String title;
   private Set<Advert> adverts = new HashSet<Advert>();

   public Category(String title) {
      this.title = title;
      this.adverts = new HashSet<Advert>();
   }

   Category() {
   }

   @ManyToMany
   @JoinTable(name="link_category_advert")
   public Set<Advert> getAdverts() {
      return adverts;
   }

   void setAdverts(Set<Advert> adverts) {
      this.adverts = adverts;
   }

   public void addAdvert(Advert advert) {
      getAdverts().add(advert);
   }

   @Column(unique=true)
   public String getTitle() {
      return title;
   }
    public void setTitle(String title) {
      this.title = title;
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