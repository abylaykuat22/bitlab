package servlets;

import db.DBCountriesConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.County;

@WebServlet(value = "/countries")
public class CountriesServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<County> counties = DBCountriesConnector.getCounties();
    req.setAttribute("strany", counties);
    req.getRequestDispatcher("countries.jsp").forward(req, resp);
  }
}
