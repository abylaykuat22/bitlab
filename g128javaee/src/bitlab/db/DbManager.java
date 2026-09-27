package bitlab.db;

import bitlab.entity.Employee;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

  private static Long id = 8L;
  private static List<Employee> employees = new ArrayList<>(
      List.of(
          new Employee(1L, "Zhanyla", "Z", "IT", 500000),
          new Employee(2L,"Ikram", "I", "IT", 500000),
          new Employee(3L, "Kobe", "Bryant", "Player", 500000),
          new Employee(4L,"Tobi", "M", "Actor", 500000),
          new Employee(5L, "Tanya", "M", "Manager", 500000),
          new Employee(6L, "Sasha", "S", "HR", 500000),
          new Employee(7L, "Diana", "D", "Recrutor", 500000)
      )
  );

  public static List<Employee> getEmployees() {
    return employees;
  }

  public static void addEmployee(Employee employee) {
    employee.setId(id);
    employees.add(employee);
    id++;
  }

  public static Employee getEmployeeById(Long id) {
    return employees.stream()
        .filter(employee -> id.equals(employee.getId()))
        .findFirst()
        .orElse(null);
  }

  public static void editEmployee(Long id, String name, String surname, String department, Integer salary) {
    Employee employee = DbManager.getEmployeeById(id);
    employee.setName(name);
    employee.setSurname(surname);
    employee.setDepartment(department);
    employee.setSalary(salary);
  }

  public static void deleteEmployeeById(Long id) {
    employees.removeIf(employee -> id.equals(employee.getId()));
  }
}
