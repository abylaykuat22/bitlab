package bitlab.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

  static Connection connection;

  static {
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(
          "jdbc:postgresql://localhost:5432/bitlabdb",
          "halykfinance",
          "halykfinance"
      );
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
