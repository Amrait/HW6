package kozak.hw6.dao;

import kozak.hw6.model.Mechanic;
import kozak.hw6.model.ServiceStation;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Олексій on 02.03.2017.
 */
public class MechanicDAOImplTest {
    private static final MechanicDAO mechanicDAO = new MechanicDAOImpl();
    @Test
    public void addMechanic() throws Exception {
        //тут усе летить шкереберть
        //наскільки я зрозумів, то через генерацію хеш-коду
        //бо починається виклик генерації хеш-коду для Station
        //а у генерації хеш-коду для Station генерується хеш-код для колекції Mechanics
        //а там генерується хеш-код для Station і так аж до StackOverFlowException
        //гадки не маю, як це обійти
        //поки що я закоментутвав деякі рядки у генерації хеш-кодів, тому і не виконується порівняння
        Mechanic Mek = new Mechanic();
        Mek.setName("John");
        Mek.setSurname("Doe");
        ServiceStation st = new ServiceStation();
        st.setService_id(1L);
        st.setAddress("Ужгород");
        Mek.setServiceStation(st);
        Mechanic receivedMek = new Mechanic();
        try {
            mechanicDAO.addMechanic(Mek);
            receivedMek = mechanicDAO.getMechanicById(Mek.getMechanicId());
            assertEquals("Хоп, а механіки різні! Той, що була доданий в тестових цілях" +
                    " і отриманий - різні.", Mek,receivedMek);
            mechanicDAO.deleteMechanicById(Mek.getMechanicId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateMechanic() throws Exception {
        Mechanic Mek = new Mechanic();
        Mek.setName("John");
        Mek.setSurname("Doe");
        ServiceStation st = new ServiceStation();
        st.setService_id(1L);
        st.setAddress("Ужгород");
        Mek.setServiceStation(st);
        Mechanic receivedMek = new Mechanic();
        try {
            mechanicDAO.addMechanic(Mek);
            receivedMek = mechanicDAO.getMechanicById(Mek.getMechanicId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Mek.setName("Jane");
        Mek.setSurname("Shepard");
        try {
            mechanicDAO.updateMechanic(Mek);
            receivedMek = mechanicDAO.getMechanicById(Mek.getMechanicId());
            assertEquals("Очевидно, оновлення пройшло не так, як плановано.", Mek,receivedMek);
            mechanicDAO.deleteMechanicById(Mek.getMechanicId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMechanicById() throws Exception {
        Mechanic Mek = new Mechanic();
        Mek.setName("John");
        Mek.setSurname("Doe");
        ServiceStation st = new ServiceStation();
        st.setService_id(1L);
        st.setAddress("Ужгород");
        Mek.setServiceStation(st);
        Mechanic receivedMek = new Mechanic();
        try {
            mechanicDAO.addMechanic(Mek);
            receivedMek = mechanicDAO.getMechanicById(Mek.getMechanicId());
            assertEquals("Хоп, а механіки різні! Той, що була доданий в тестових цілях" +
                    " і отриманий - різні.", Mek,receivedMek);
            mechanicDAO.deleteMechanicById(Mek.getMechanicId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteMechanicById() throws Exception {
        Mechanic Mek = new Mechanic();
        Mek.setName("John");
        Mek.setSurname("Doe");
        ServiceStation st = new ServiceStation();
        st.setService_id(1L);
        st.setAddress("Ужгород");
        Mek.setServiceStation(st);
        Mechanic receivedMek = new Mechanic();
        try {
            mechanicDAO.addMechanic(Mek);
            mechanicDAO.deleteMechanicById(Mek.getMechanicId());
            receivedMek = mechanicDAO.getMechanicById(Mek.getMechanicId());
            assertEquals("Схоже, видалення пройшло погано.", null,receivedMek);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}