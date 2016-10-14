package sample;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import sample.dao.DAO;
import sample.entity.Advert;
import sample.entity.Category;
import sample.entity.User;

public class PostAdvert extends DAO {

    public static void main(String[] args) {

        if (args.length != 4) {
            System.out.println("params required: username, categoryTitle, title, message");
            return;
        }

        String username = args[0];
        String categoryTitle = args[1];
        String title = args[2];
        String message = args[3];

        try {

            PostAdvert self = new PostAdvert();

            System.out.println("Creating advert");
            Advert advert = self.create(username,categoryTitle,title, message);
            System.out.println("Created advert");

            DAO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Advert create(String username, String categoryTitle,
            String title, String message)
            throws Exception {
        try {
            begin();

            //get the user by username
            Query userQuery = getSession().createQuery(" from User where name = :username");
            userQuery.setString("username", username);
            User user = (User) userQuery.uniqueResult();

            //get the category by category title
            Query categoryQuery = getSession().createQuery(" from Category where title = :categoryTitle");
            categoryQuery.setString("categoryTitle", categoryTitle);
            Category category = (Category) categoryQuery.uniqueResult();


            //create and save the new advert
            Advert advert = new Advert(title, message, user);
            getSession().save(advert);

            //add the advert to the category and save
            category.addAdvert(advert);
            getSession().save(category);

            commit();
            return advert;
        } catch (HibernateException e) {
            throw new Exception("Could not create advert " + title, e);
        }
    }
}
      