package kozak.hw6.dao;

import kozak.hw6.model.ServiceStation;

import java.sql.SQLException;

/**
 * Created by Олексій on 02.03.2017.
 */
public interface ServiceStationDAO {
    void addService(ServiceStation service) throws SQLException;
    void updateService(ServiceStation service) throws SQLException;
    ServiceStation getServiceById(Long service_id) throws SQLException;
    void deleteServiceById(Long service_id) throws SQLException;
}
