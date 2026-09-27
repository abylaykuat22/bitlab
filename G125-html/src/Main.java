import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    Employee employee1 = new Employee("John", "Aikenov", 65, 747588.0);
    Employee employee2 = new Employee("Jane", "Doe", 55, 96857);
    Employee employee3 = new Employee("Bob", "Smith", 25, 70000.0);
    Employee employee4 = new Employee("Alice", "Johnson", 18, 45000.0);
    Employee employee5 = new Employee("Peter", "Lee", 55, 650450);
    Employee employee6 = new Employee("Sarah", "Garcia", 55, 90000.0);
    Employee employee7 = new Employee("Tom", "Amirov", 45, 690870);
    Employee employee8 = new Employee("Mike", "Wilson", 45, 74580);

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(employee1);
    employeeList.add(employee2);
    employeeList.add(employee3);
    employeeList.add(employee4);
    employeeList.add(employee5);
    employeeList.add(employee6);
    employeeList.add(employee7);
    employeeList.add(employee8);

    boolean isCorrect = employeeList.stream()
        .allMatch(employee -> employee.getAge() >= 18);

    if (!isCorrect) {
      System.out.println("У вас работает несовершеннолетний сотрудник");
    }
  }
}
