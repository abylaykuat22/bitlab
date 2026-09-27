package bitlab.servlet;

import bitlab.db.DbManager;
import bitlab.entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(value = "/home")
public class EmployeeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<Employee> employees = DbManager.getEmployees();
    req.setAttribute("rabotniki", employees);
    req.getRequestDispatcher("employee.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    String surname = req.getParameter("surname");
    String department = req.getParameter("department");
    String salaryStr = req.getParameter("salary");
    Integer salary = Optional.ofNullable(salaryStr)
        .filter(value -> !value.isEmpty())
        .map(Integer::valueOf)
        .orElse(null);

    // Если имя или фамилия null, то нет смысла продолжать текущий метод
    if (name != null && !name.isEmpty() && surname != null && !surname.isEmpty()) {
      Employee employee = new Employee(null, name, surname, department, salary);
      DbManager.addEmployee(employee);
    }

    resp.sendRedirect("/home");
  }
}
