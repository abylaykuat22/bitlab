package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.Developer;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    List<Developer> developers = DBUtil.getDevelopers();
    request.setAttribute("razraby", developers);
    request.getRequestDispatcher("home.jsp").forward(request, response); // метод для отображения jsp файла
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("developerName");
    String surname = req.getParameter("surname");
    String city = req.getParameter("city");
    Integer age = Integer.parseInt(req.getParameter("age"));
    Developer developer = new Developer();
    developer.setName(name);
    developer.setSurname(surname);
    developer.setBirthCity(city);
    developer.setAge(age);
    DBUtil.addDeveloper(developer);
    resp.sendRedirect("/home");
  }

}
