package kz.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import kz.bitlab.db.UserDb;
import kz.bitlab.models.User;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

  private static final String USER_EMAIL = "email";
  private static final String USER_PASSWORD = "password";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    var currentUser = (User) req.getSession().getAttribute("currentUser");
    if (currentUser != null) {
      resp.sendRedirect("/");
      return;
    }
    req.getRequestDispatcher("signin.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String email = req.getParameter(USER_EMAIL);
    String password = req.getParameter(USER_PASSWORD);
    String redirect = "/sign-in?errorEmail";
    User user = UserDb.getUserByEmail(email);
    if (user != null) {
      redirect = "/sign-in?errorPassword";
      if (password.equals(user.getPassword())) {
        redirect = "/";
        req.getSession().setAttribute("currentUser", user);
      }
    }
    resp.sendRedirect(redirect);
  }
}
