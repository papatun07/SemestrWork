package service;

import dao.CarDao;
import dao.UserDao;
import entity.Car;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class CarService {
    private static final CarDao carDao = new CarDao();

    public void save(Car car) throws SQLException {
        carDao.save(car);
    }
//    public List<Car> getAllCars() throws SQLException {
//        return carDao.findAll();
//    }
}
