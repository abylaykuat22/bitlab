package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Phone;

@WebServlet(value = "/phoneDetails")
public class DetailsPhoneServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Phone phone = DBConnector.getPhoneById(id);
    req.setAttribute("sotka", phone);
    req.getRequestDispatcher("details.jsp").forward(req, resp);
  }
}
