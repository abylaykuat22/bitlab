package servlets;

import db.DBUsersConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.City;
import models.User;

@WebServlet(value = "/users")
public class UsersServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<User> users = DBUsersConnector.getUsers();
    req.setAttribute("users", users);
    List<City> cities = DBUsersConnector.getCities();
    req.setAttribute("goroda", cities);
    req.getRequestDispatcher("users.jsp").forward(req, resp);
  }
}
