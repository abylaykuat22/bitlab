package bitlab.servlet;

import bitlab.db.DbManager;
import bitlab.entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/employee")
public class EmployeeEditServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    Employee employee = DbManager.getEmployeeById(id);
    req.setAttribute("rabotnik", employee);
    req.getRequestDispatcher("/employeeEdit.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Long id = Long.parseLong(req.getParameter("id"));
    String name = req.getParameter("name");
    String surname = req.getParameter("surname");
    String department = req.getParameter("department");
    String salaryStr = req.getParameter("salary");
    Integer salary = Optional.ofNullable(salaryStr)
        .filter(value -> !value.isEmpty())
        .map(Integer::valueOf)
        .orElse(null);

    DbManager.editEmployee(id, name, surname, department, salary);
    resp.sendRedirect("/home");
  }
}
