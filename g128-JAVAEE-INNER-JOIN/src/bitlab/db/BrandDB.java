package bitlab.db;

import bitlab.entity.Brand;
import bitlab.entity.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDB extends DBConnector {

  public static Brand findById(Long id) {
    Brand brand = null;
    try {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM brands WHERE id = ?"
      );
      statement.setLong(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        brand = new Brand();
        brand.setId(id);
        brand.setName(resultSet.getString("name"));
        brand.setShortName(resultSet.getString("short_name"));
        brand.setCountry(resultSet.getString("country"));
      }
      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return brand;
  }

  public static List<Brand> findAll() {
    List<Brand> brands = new ArrayList<>();
    try {
      var statement = connection.prepareStatement(
          "SELECT * FROM brands"
      );
      var resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Brand brand = new Brand();
        brand.setId(resultSet.getLong("id"));
        brand.setName(resultSet.getString("name"));
        brand.setShortName(resultSet.getString("short_name"));
        brand.setCountry(resultSet.getString("country"));
        brands.add(brand);
      }
      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return brands;
  }
}
