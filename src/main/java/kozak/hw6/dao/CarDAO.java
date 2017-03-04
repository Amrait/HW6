package kozak.hw6.dao;

import kozak.hw6.model.Car;

import java.sql.SQLException;

/**
 * Created by Олексій on 01.03.2017.
 */
public interface CarDAO {
    void addCar(Car car) throws SQLException;
    void updateCar(Car car) throws SQLException;
    Car getCarById(Long car_id) throws SQLException;
    void deleteCarById(Long car_id) throws SQLException;
}
