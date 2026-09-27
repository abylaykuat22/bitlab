package servlets;

import db.DbManager;
import db.DbUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Task;

@WebServlet("/add-task-servlet")
public class AddTaskServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("task_name");
    String description = req.getParameter("task_description");
    String deadlineDate = req.getParameter("task_deadlineDate");
    Task task = new Task();
    task.setName(name);
    task.setDescription(description);
    task.setDeadlineDate(deadlineDate);
    DbUtil.addTask(task);
    resp.sendRedirect("/");
  }
}
