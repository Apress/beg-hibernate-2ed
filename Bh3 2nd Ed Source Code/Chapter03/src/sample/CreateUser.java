package sample;

import org.hibernate.HibernateException;
import sample.dao.DAO;
import sample.entity.User;

public class CreateUser extends DAO {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("params required: username, password");
            return;
        }
        String username = args[0];
        String password = args[1];

        try {
            CreateUser self = new CreateUser();
            System.out.println("Creating user " + username);
            self.create(username,password);
            System.out.println("Created user");
            DAO.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public User create(String username, String password)
            throws Exception
    {
        try
        {
            begin();
            User user = new User(username, password);
            getSession().save(user);
            commit();
            return user;
        }
        catch (HibernateException e)
        {
            throw new Exception("Could not create user " + username, e);
        }
    }
}
