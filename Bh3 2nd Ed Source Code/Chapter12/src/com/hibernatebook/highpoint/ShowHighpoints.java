

package com.hibernatebook.highpoint;

import com.hibernatebook.highpoint.entity.Admin1Code;
import com.hibernatebook.highpoint.entity.Place;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ShowHighpoints {
public static void main(String[] args) {
        SessionFactory factory =
                new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = factory.openSession();


        Query statesQuery = session.createQuery("from Admin1Code where country_code = 'US'");
        List<Admin1Code> states = statesQuery.list();
        for (Admin1Code state : states) {
            Query elevationQuery = session.createQuery(
                    "select max(elevation) from Place where admin1_code = :state");
            elevationQuery.setString("state", state.getAdmin1Code());
            Integer highpointElevation = (Integer) elevationQuery.uniqueResult();


            Query stateHighpointsQuery = session.createQuery(
                    "from Place where admin1_code = :state and elevation = :highpointElevation");
            stateHighpointsQuery.setString("state", state.getAdmin1Code());
            stateHighpointsQuery.setInteger("highpointElevation", highpointElevation);

            List<Place> highpoints = stateHighpointsQuery.list();
            for (Place highpoint : highpoints)
            {
                highpointElevation = highpoint.getElevation();
                String output = state.getName() + ":" + highpoint.getName() + ":" + highpointElevation + ":";

                if (highpoint.getFeatureCode() != null)
                {
                    output = output + highpoint.getFeatureCode().getName() + ":";
                }
                else
                {
                    output = output + "N/A:";
                }

                if (highpoint.getAdmin2Code() != null)
                {
                    output = output + highpoint.getAdmin2Code().getName();
                }
                else
                {
                    output = output + "N/A";
                }

                System.out.println(output);

            }
        } 

        session.close();
    }
}
