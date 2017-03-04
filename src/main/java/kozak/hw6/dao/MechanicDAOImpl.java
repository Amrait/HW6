package kozak.hw6.dao;

import kozak.hw6.model.Mechanic;
import kozak.hw6.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by Олексій on 02.03.2017.
 */
public class MechanicDAOImpl implements MechanicDAO {
    public void addMechanic(Mechanic mechanic) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(mechanic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateMechanic(Mechanic mechanic) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(mechanic);
            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        } finally {
            if(session!=null && session.isOpen())
            {
                session.close();
            }
        }
    }

    public Mechanic getMechanicById(Long mechanic_id) {
        Session session = null;
        Mechanic mechanic = null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            mechanic = (Mechanic) session.get(Mechanic.class, mechanic_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return mechanic;
    }

    public void deleteMechanicById(Long mechanic_id) {
        Session session = null;
        Mechanic mechanic = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            mechanic = (Mechanic) session.get(Mechanic.class,mechanic_id);
            session.delete(mechanic);
            session.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
