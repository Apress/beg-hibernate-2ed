package com.hibernatebook.session.deadlock;

public class Publisher {
   public Publisher() {
   }

   public Publisher(String username) {
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
