package dao;

import Util.ConnectionProvider;
import Util.DbException;
import entity.Car;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarDao {
    private ConnectionProvider connectionProvider;
    public CarDao(){};
    public CarDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public void save(Car car) throws SQLException {
        // language=SQL
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("insert into car (brand,model,price_for_day) values (?,?,?)");
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int getCount() throws DbException{
        try {
            Statement statement = this.connectionProvider.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(id) AS cnt FROM car");
            resultSet.next();
            return resultSet.getInt("cnt");
        } catch (SQLException e) {
            throw new DbException("Cant get count of cars", e);
        }
    }


    public List<Car> getPage() throws DbException {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM car");
            ResultSet result = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (result.next()){
                Car car = new Car(
                        result.getInt("id"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getString("price_for_day")
//                        result.getBytes("image_data"),
//                        result.getString("image_file_name")
                );
                cars.add(car);
            }
            System.out.println(cars);
            return cars;
        } catch (SQLException e) {
            throw new DbException("Cant get car from db", e);
        }
    }

    public Car getDetail(int id) throws DbException {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM car WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            boolean hasOne = result.next();
            if(hasOne) {
                return new Car(
                        result.getInt("id"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getString("price_for_day")
                );
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Cant get car from db", e);
        }
    }
//    public List<Car> findAll() throws SQLException {
//        // language=SQL
//        try {PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM car");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            List<Car> list = new LinkedList<>();
//
//            while (resultSet.next()) {
//                Car car = Car.builder()
//                        .id(resultSet.getInt("id"))
//                        .brand(resultSet.getString("brand"))
//                        .model(resultSet.getString("model"))
//                        .price(resultSet.getInt("price_for_day"))
//                        .build();
//                list.add(car);
//            }
//
//            return list;
//
//        } catch (SQLException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }
}

