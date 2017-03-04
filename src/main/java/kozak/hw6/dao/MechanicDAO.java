package kozak.hw6.dao;

import kozak.hw6.model.Mechanic;
import java.sql.SQLException;

/**
 * Created by Олексій on 02.03.2017.
 */
public interface MechanicDAO {
    void addMechanic(Mechanic mechanic) throws SQLException;
    void updateMechanic(Mechanic mechanic) throws SQLException;
    Mechanic getMechanicById(Long mechanic_id) throws SQLException;
    void deleteMechanicById(Long mechanic_id) throws SQLException;
}
