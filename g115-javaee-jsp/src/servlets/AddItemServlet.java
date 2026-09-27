package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/add-item")
public class AddItemServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    double price = Double.parseDouble(req.getParameter("price"));
    int amount = Integer.parseInt(req.getParameter("amount"));
    DBManager.addItem(name, price, amount);
    resp.sendRedirect("/");
  }
}
