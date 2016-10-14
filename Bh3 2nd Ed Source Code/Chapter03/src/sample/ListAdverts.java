package sample;

import java.util.Iterator;
import java.util.List;

import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import sample.dao.DAO;
import sample.entity.Advert;
import sample.entity.Category;

public class ListAdverts extends DAO{

    public static void main(String[] args) {
        try {

            ListAdverts self = new ListAdverts();
            List<Category> categories = self.list();

            for(Category category : categories) {
                System.out.println("Category: " + category.getTitle());
                System.out.println();
                Set <Advert> adverts = category.getAdverts();

                for (Advert advert : adverts) {
                    System.out.println();
                    System.out.println("Title: " + advert.getTitle());
                    System.out.println(advert.getMessage());
                    System.out.println(" posted by " + advert.getUser().getName());
                }
            }

            DAO.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public List<Category> list() throws Exception {
        try
        {
            begin();
            Query query = getSession().createQuery("from Category");
            List<Category> list = query.list();

            commit();
            return list;
        }
        catch (HibernateException e)
        {
            rollback();
            throw new Exception("Could not list the categories",e);
        }
    }
}
      