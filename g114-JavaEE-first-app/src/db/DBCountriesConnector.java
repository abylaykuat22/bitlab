package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.County;

public class DBCountriesConnector {

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

  public static List<County> getCounties() {
    List<County> counties = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "select * from countries order by name ASC ");
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        County county = new County();
        county.setId(resultSet.getLong("id"));
        county.setName(resultSet.getString("name"));
        county.setShortName(resultSet.getString("short_name"));
        counties.add(county);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return counties;
  }

  public static void addCountry(County county) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "insert into countries(name, short_name) "
              + "values (?, ?)");
      statement.setString(1, county.getName());
      statement.setString(2, county.getShortName());
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void editCountry(County county) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "update countries set name=?, short_name=? "
              + "where id = ?");
      statement.setString(1, county.getName());
      statement.setString(2, county.getShortName());
      statement.setLong(3, county.getId());
      statement.executeUpdate();
      statement.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
}
