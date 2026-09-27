package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.City;
import models.Street;
import models.User;

public class DBUsersConnector {

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/g114-JavaEE-JDBC",
          "postgres",
          "postgres");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<User> getUsers() {
    List<User> users = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select u.id, u.full_name, u.age, c.id as city_id, c.name, c.code, "
              + "s.id as street_id,s.name as street_name, s.index from users u "
              + "inner join cities c on u.city_id = c.id "
              + "inner join streets s on c.street_id = s.id");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFullName(resultSet.getString("full_name"));
        user.setAge(resultSet.getInt("age"));

        City city = new City();
        city.setId(resultSet.getLong("city_id"));
        city.setName(resultSet.getString("name"));
        city.setCode(resultSet.getString("code"));

        Street street = new Street();
        street.setId(resultSet.getLong("street_id"));
        street.setName(resultSet.getString("street_name"));
        street.setIndex(resultSet.getString("index"));

        city.setStreet(street);

        user.setCity(city);
        users.add(user);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return users;
  }

  public static List<City> getCities() {
    List<City> cities = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from cities");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        City city = new City();
        city.setId(resultSet.getLong("id"));
        city.setName(resultSet.getString("name"));
        city.setCode(resultSet.getString("code"));
        cities.add(city);
      }
      statement.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
    return cities;
  }

  public static City getCityById(Long id) {
    City city = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from cities where id=?");
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        city = new City();
        city.setId(resultSet.getLong("id"));
        city.setName(resultSet.getString("name"));
        city.setCode(resultSet.getString("code"));
      }
      statement.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
    return city;
  }

  public static void addUser(User user) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "insert into users(full_name, age, city_id) "
              + "values (?, ?, ?)");
      statement.setString(1, user.getFullName());
      statement.setInt(2, user.getAge());
      statement.setLong(3, user.getCity().getId());
      statement.executeUpdate();
      statement.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
}
