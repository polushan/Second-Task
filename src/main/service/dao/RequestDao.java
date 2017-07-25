package dao;

import model.Request;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;

public class RequestDao {

    public void saveRequest(Request request) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(request);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
