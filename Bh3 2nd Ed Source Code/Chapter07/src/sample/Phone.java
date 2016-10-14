package sample;

public class Phone {
   public Phone(User user, String number, String comment) {
      this.user = user;
      this.number = number;
      this.comment = comment;
   }
   
   Phone() {
   }

   /**
    * 
    * @uml.property name="comment"
    */
   public String getComment() {
      return comment;
   }

   /**
    * 
    * @uml.property name="comment"
    */
   public void setComment(String comment) {
      this.comment = comment;
   }

   /**
    * 
    * @uml.property name="number"
    */
   public String getNumber() {
      return number;
   }

   /**
    * 
    * @uml.property name="number"
    */
   public void setNumber(String number) {
      this.number = number;
   }

   /**
    * 
    * @uml.property name="user"
    */
   public User getUser() {
      return user;
   }

   /**
    * 
    * @uml.property name="user"
    */
   public void setUser(User user) {
      this.user = user;
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

   /**
    * 
    * @uml.property name="user"
    * @uml.associationEnd multiplicity="(0 1)"
    */
   private User user;
   private String number;
   private String comment;   
}
