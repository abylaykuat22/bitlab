package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Phone;

@WebServlet(value = "/addPhone")
public class AddPhoneServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("addPhone.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    String description = req.getParameter("description");
    double price = Double.parseDouble(req.getParameter("price"));
    Phone phone = new Phone();
    phone.setName(name);
    phone.setDescription(description);
    phone.setPrice(price);
    DBConnector.addPhone(phone);
    resp.sendRedirect("/");
  }
}
