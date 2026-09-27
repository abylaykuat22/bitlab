package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import kz.bitlab.models.User;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    var currentUser = (User) req.getSession().getAttribute("currentUser");
    if (currentUser == null) {
      resp.sendRedirect("/sign-in");
      return;
    }
    req.getRequestDispatcher("home.jsp").forward(req, resp);
  }
}
