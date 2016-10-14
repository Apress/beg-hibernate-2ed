    package sample.entity;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity
    @Table (name="AdUser")
    public class User {
       private long id;
       private String name;
       private String password;

       public User(String name, String password) {
          this.name = name;
          this.password = password;
       }

       User() {
       }

       @Column(unique=true)
       public String getName() {
          return name;
       }

       public void setName(String name) {
          this.name = name;
       }

       public String getPassword() {
          return password;
       }

       public void setPassword(String password) {
          this.password = password;
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