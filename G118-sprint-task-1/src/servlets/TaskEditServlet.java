package servlets;

import db.DbUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.Task;

@WebServlet(value = "/task-edit")
public class TaskEditServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("task_id"));
    String name = req.getParameter("task_name");
    String description = req.getParameter("task_description");
    String deadlineDate = req.getParameter("task_deadlineDate");
    Task task = DbUtil.getTaskById(id);
    if (task != null) {
      task.setName(name);
      task.setDescription(description);
      task.setDeadlineDate(deadlineDate);
    }
    DbUtil.editTask(task);
    resp.sendRedirect("/");
  }
}
