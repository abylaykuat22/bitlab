package kz.bitlab.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import kz.bitlab.models.Role;
import kz.bitlab.models.User;
import static kz.bitlab.models.constant.ColumnConstant.*;

public class UserDb extends DbConnector {

  public static User getUserByEmail(String email) {
    User user = null;
    try {
      var statement = connection.prepareStatement(
          "SELECT u.*, r.name FROM FINAL.USERS u "
              + "INNER JOIN FINAL.ROLES r ON u.role_id = r.id "
              + "WHERE email = ?");
      statement.setString(1, email);
      var resultSet = statement.executeQuery();
      if (resultSet.next()) {
        user = new User();
        user.setEmail(email);
        user.setId(resultSet.getLong(USER_ID));
        user.setPassword(resultSet.getString(USER_PASSWORD));
        user.setFullName(resultSet.getString(USER_FULL_NAME));

        Role role = new Role();
        role.setId(resultSet.getLong(USER_ROLE_ID));
        role.setName(resultSet.getString(ROLE_NAME));
        user.setRole(role);
      }
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }
}
