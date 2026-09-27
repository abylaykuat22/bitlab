package servlets;

import db.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Developer;

@WebServlet(value = "/details")
public class DeveloperDetailsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Developer developer = DBUtil.getDeveloperById(id);
    req.setAttribute("razrab", developer);
    req.getRequestDispatcher("details.jsp").forward(req, resp);
  }
}
