package servlets;

import db.DBConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Phone;

@WebServlet(value = "/editPhone")
public class EditPhoneServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    String name = req.getParameter("name");
    String description = req.getParameter("description");
    double price = Double.parseDouble(req.getParameter("price"));
    Phone phone = new Phone();
    phone.setId(id);
    phone.setName(name);
    phone.setDescription(description);
    phone.setPrice(price);
    DBConnector.editPhone(phone);
    resp.sendRedirect("/phoneDetails?id="+id);
  }
}
