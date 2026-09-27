package com.example.g139springfirst.service;

import com.example.g139springfirst.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final Connection connection;

    public void addCar(Car car) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO cars (NAME, YEAR, PRICE, COLOR) VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, car.getName());
            statement.setInt(2, car.getYear());
            statement.setDouble(3, car.getPrice());
            statement.setString(4, car.getColor());

            statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error in adding Car");
        }
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM cars"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getLong("id"));
                car.setName(resultSet.getString("name"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getDouble("price"));
                car.setColor(resultSet.getString("color"));
                cars.add(car);
            }
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error in getAllCars");
        }

        return cars;
    }

    public Car getCarById(Long id) {
        Car car = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM cars WHERE id = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car = new Car();
                car.setId(id);
                car.setName(resultSet.getString("name"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getDouble("price"));
                car.setColor(resultSet.getString("color"));
            }

            statement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error in getCarById");
        }
        return car;
    }

    public void deleteCarById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM cars WHERE id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error in deleteCarById");
        }
    }

    public void updateCar(Car car) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE cars SET name = ?, year = ?, price = ?, color = ? WHERE id = ?"
            );
            statement.setString(1, car.getName());
            statement.setInt(2, car.getYear());
            statement.setDouble(3, car.getPrice());
            statement.setString(4, car.getColor());
            statement.setLong(5, car.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in updateCar");
        }
    }


    // Комментарии:
    // Куат
    // куат2
    // не куат
}
