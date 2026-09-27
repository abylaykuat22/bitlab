package servlets;


import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Item;


@WebServlet(value = "/edit-item")
public class EditItemServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("item_id"));
    String name = req.getParameter("item_name");
    double price = Double.parseDouble(req.getParameter("item_price"));
    int amount = Integer.parseInt(req.getParameter("item_amount"));

    Item item = DBManager.getItemById(id);
    item.setName(name);
    item.setPrice(price);
    item.setAmount(amount);

    resp.sendRedirect("/details?id="+id);
  }
}
