package kozak.hw6.dao;

import kozak.hw6.model.Car;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Олексій on 02.03.2017.
 */
public class CarDAOImplTest {
    private static final CarDAO carDAO = new CarDAOImpl();

    @Test
    public void addCar() throws Exception {
        //отут цікавий момент, який мені складно пояснити
        //ми якби тестуємо метод add() і перевіряємо, чи те він додав
        //і використовуємо getCarById (вважаючи, що він працює справно)
        //для отримання запису з таблиці і порівняння з тим, що ми вже додали
        //Але в принципі, як це буде відрізнятися від тесту методу getCarById,
        //якщо там все те саме, тільки тестова функція інша?
        Car car = new Car();
        car.setPrice(10000L);
        car.setModel("Test model");
        car.setCreator("Test Creator");
        car.setEngineId(15);
        car.setDate(new Date(123431504635L).toString());
        Car receivedCar = new Car();
        try {
            carDAO.addCar(car);
            receivedCar = carDAO.getCarById(car.getId());
            assertEquals("Хоп, а машини різні! Та, що була додана в тестових цілях" +
                    " і отримана - різні.", car,receivedCar);
            carDAO.deleteCarById(car.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateCar() throws Exception {
        Car car = new Car();
        car.setPrice(10000L);
        car.setModel("Test model");
        car.setCreator("Test Creator");
        car.setEngineId(15);
        car.setDate(new Date(123431504635L).toString());
        try {
            carDAO.addCar(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        car.setPrice(50000L);
        car.setModel("Another model");
        Car receivedCar = new Car();
        try {
            carDAO.updateCar(car);
            receivedCar = carDAO.getCarById(car.getId());
            assertEquals("Хоп, а машини різні! Отриманий з таблиці запис не відповідає оновленому.", car,receivedCar);
            carDAO.deleteCarById(car.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCarById() throws Exception {
        Car car = new Car();
        car.setPrice(10000L);
        car.setModel("Test model");
        car.setCreator("Test Creator");
        car.setEngineId(15);
        car.setDate(new Date(123431504635L).toString());
        Car receivedCar = new Car();
        try {
            carDAO.addCar(car);
            receivedCar = carDAO.getCarById(car.getId());
            assertEquals("Хоп, а машини різні! Та, що була додана в тестових цілях" +
                    " і отримана - різні.", car,receivedCar);
            carDAO.deleteCarById(car.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteCarById() throws Exception {
        Car car = new Car();
        car.setPrice(10000L);
        car.setModel("Test model");
        car.setCreator("Test Creator");
        car.setEngineId(15);
        car.setDate(new Date(123431504635L).toString());
        Car receivedCar = new Car();
        try {
            carDAO.addCar(car);
            carDAO.deleteCarById(car.getId());
            receivedCar = carDAO.getCarById(car.getId());
            assertEquals("Хоп, а машини різні! Схоже, запис не було видалено", null,receivedCar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}