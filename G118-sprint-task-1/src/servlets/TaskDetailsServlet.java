package servlets;

import db.DbUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Task;

@WebServlet(value = "/task-details")
public class TaskDetailsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Task task = DbUtil.getTaskById(id);
    req.setAttribute("zadanye", task);
    req.getRequestDispatcher("taskDetails.jsp").forward(req, resp);
  }
}
