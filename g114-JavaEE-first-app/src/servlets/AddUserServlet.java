package servlets;

import db.DBUsersConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.City;
import models.User;

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String fullName = req.getParameter("fullName");
    int age = Integer.parseInt(req.getParameter("age"));
    Long cityId = Long.parseLong(req.getParameter("city.id"));

    City city = DBUsersConnector.getCityById(cityId);

    User user = new User();
    user.setFullName(fullName);
    user.setAge(age);
    user.setCity(city);

    DBUsersConnector.addUser(user);
    resp.sendRedirect("/users");
  }
}
