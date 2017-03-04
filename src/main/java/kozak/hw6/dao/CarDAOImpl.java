package kozak.hw6.dao;

import kozak.hw6.model.Car;
import kozak.hw6.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

/**
 * Created by Олексій on 01.03.2017.
 */
public class CarDAOImpl implements CarDAO {
    public void addCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateCar(Car car) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(car);
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

    public Car getCarById(Long car_id) {
        Session session = null;
        Car car = null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            car = (Car) session.get(Car.class, car_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return car;
    }

    public void deleteCarById(Long car_id) {
        Session session = null;
        Car car = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            car = (Car) session.get(Car.class,car_id);
            session.delete(car);
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
