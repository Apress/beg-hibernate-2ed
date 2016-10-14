package sample;

import java.util.HashSet;
import java.util.Set;

public class Category {
   public Category(String title) {
      this.title = title;
      this.adverts = new HashSet();
   }
   
   Category() {
   }

   /**
    * 
    * @uml.property name="adverts"
    */
   public Set getAdverts() {
      return adverts;
   }

   /**
    * 
    * @uml.property name="adverts"
    */
   public void setAdverts(Set adverts) {
      this.adverts = adverts;
   }

   /**
    * 
    * @uml.property name="title"
    */
   public String getTitle() {
      return title;
   }

   /**
    * 
    * @uml.property name="title"
    */
   public void setTitle(String title) {
      this.title = title;
   }

   /**
    * 
    * @uml.property name="id"
    */
   protected long getId() {
      return id;
   }

   /**
    * 
    * @uml.property name="id"
    */
   protected void setId(long id) {
      this.id = id;
   }

   private long id;
   private String title;
   private Set adverts;
}
