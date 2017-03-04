package kozak.hw6.dao;

import kozak.hw6.model.ServiceStation;
import kozak.hw6.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by Олексій on 02.03.2017.
 */
public class ServiceStationDAOImpl implements ServiceStationDAO{
    public void addService(ServiceStation service) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(service);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateService(ServiceStation service) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(service);
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

    public ServiceStation getServiceById(Long service_id) {
        Session session = null;
        ServiceStation service = null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            service = (ServiceStation) session.get(ServiceStation.class, service_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return service;
    }

    public void deleteServiceById(Long service_id) {
        Session session = null;
        ServiceStation service = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            service = (ServiceStation) session.get(ServiceStation.class,service_id);
            session.delete(service);
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
