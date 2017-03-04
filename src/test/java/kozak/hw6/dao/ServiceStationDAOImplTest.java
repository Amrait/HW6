package kozak.hw6.dao;

import kozak.hw6.model.ServiceStation;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Олексій on 02.03.2017.
 */
public class ServiceStationDAOImplTest {
    private static final ServiceStationDAO stationDAO = new ServiceStationDAOImpl();
    @Test
    public void addService() throws Exception {
        ServiceStation station = new ServiceStation();
        station.setAddress("Хорол");
        ServiceStation receivedStation = new ServiceStation();
        try {
            stationDAO.addService(station);
            receivedStation = stationDAO.getServiceById(1L);
//            assertEquals("Об'єкти не збігаються", station,receivedStation);
            System.out.println(receivedStation);
//            stationDAO.deleteServiceById(station.getService_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateService() throws Exception {

    }

    @Test
    public void getServiceById() throws Exception {

    }

    @Test
    public void deleteServiceById() throws Exception {

    }

}