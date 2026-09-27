package bitlab.db;

import bitlab.entity.Brand;
import bitlab.entity.Item;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDB extends DBConnector {

  // CREATE
  public static void createItem(Item item) {
    try {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO items(name, description, price, brand_id) "
              + "VALUES (?, ?, ?, ?)"
      );
      statement.setString(1, item.getName());
      statement.setString(2, item.getDescription());
      statement.setDouble(3, item.getPrice());
      statement.setLong(4, item.getBrand().getId());
      statement.executeUpdate();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static List<Item> findAll() {
    List<Item> items = new ArrayList<>();
    try {
      var statement = connection.prepareStatement(
          "SELECT i.id, i.name, i.description, i.price, i.brand_id, b.name AS brand_name, b.short_name AS brand_short_name, b.country AS brand_country FROM items i "
              + "INNER JOIN brands b ON i.brand_id = b.id "
              + "ORDER BY i.price"
      );
      var resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Brand brand = new Brand();
        brand.setId(resultSet.getLong("brand_id"));
        brand.setName(resultSet.getString("brand_name"));
        brand.setShortName(resultSet.getString("brand_short_name"));
        brand.setCountry(resultSet.getString("brand_country"));

        Item item = new Item();
        item.setId(resultSet.getLong("id"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setPrice(resultSet.getDouble("price"));
        item.setBrand(brand);
        items.add(item);
      }
      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return items;
  }
}
