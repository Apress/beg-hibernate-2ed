package com.hibernatebook.session.deadlock;

public class Subscriber {
   public Subscriber() {
   }

   public Subscriber(String username) {
      this.username = username;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   private String username;
}
