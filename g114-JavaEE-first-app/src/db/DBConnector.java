package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Phone;

public class DBConnector {

  private static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/g114-JavaEE-JDBC",
          "postgres",
          "postgres"
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * List<Phone> phones - жилет ResultSet - некий контейнер в котором содержатся патроны Phone -
   * магазин поля у Phone - патроны
   *
   * @return
   */
  public static List<Phone> getPhones() {
    List<Phone> phones = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from phones order by price DESC");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Phone phone = new Phone();
        phone.setId(resultSet.getLong("id"));
        phone.setName(resultSet.getString("name"));
        phone.setDescription(resultSet.getString("description"));
        phone.setPrice(resultSet.getDouble("price"));
        phones.add(phone);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return phones;
  }

  public static Phone getPhoneById(Long id) {
    Phone phone = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from phones where id=?");
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        phone = new Phone();
        phone.setId(resultSet.getLong("id"));
        phone.setName(resultSet.getString("name"));
        phone.setDescription(resultSet.getString("description"));
        phone.setPrice(resultSet.getDouble("price"));
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return phone;
  }

  public static void addPhone(Phone phone) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "insert into phones(name, description, price) "
              + "values (?,?,?)");
      statement.setString(1, phone.getName());
      statement.setString(2, phone.getDescription());
      statement.setDouble(3, phone.getPrice());
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void editPhone(Phone phone) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "update phones set "
              + "name = ?, description = ?, price =? "
              + "where id = ?");
      statement.setString(1, phone.getName());
      statement.setString(2, phone.getDescription());
      statement.setDouble(3, phone.getPrice());
      statement.setLong(4, phone.getId());
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deletePhoneById(Long id) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "delete from phones where id=?");
      statement.setLong(1, id);
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
