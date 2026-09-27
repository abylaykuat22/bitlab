package servlets;


import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Item;


@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Item item = DBManager.getItemById(id);
    req.setAttribute("zat", item);
    req.getRequestDispatcher("details.jsp").forward(req, resp);
  }

}
