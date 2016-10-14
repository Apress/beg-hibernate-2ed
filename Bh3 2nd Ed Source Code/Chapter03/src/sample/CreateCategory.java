package sample;

import org.hibernate.HibernateException;
import sample.dao.DAO;
import sample.entity.Category;

public class CreateCategory extends DAO {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("param required: categoryTitle");
            return;
        }

        CreateCategory self = new CreateCategory();
        String title = args[0];
        try {
            System.out.println("Creating category " + title);
            self.create(title);
            System.out.println("Created category");
            DAO.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Category create(String title)
            throws Exception {
        try {
            begin();
            Category category = new Category(title);
            getSession().save(category);
            commit();
            return category;
        } catch (HibernateException e) {
            throw new Exception("Could not create category " + title, e);
        }
    }
}
