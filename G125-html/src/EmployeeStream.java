import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStream {

  static void printUniqueLastNames(List<Employee> employees) {
    employees.stream()
        .map(Employee::getLastName)
        .sorted()
        .distinct()
        .collect(Collectors.toList())
        .forEach(System.out::println);
  }

  static double calculateAverageSalaryOfEmployeesYoungerThan30( List<Employee> employees) {
    return employees.stream()
        .filter(employee -> employee.getAge() < 30) // Нашли всех работников младше 30
        .map(Employee::getSalary)  // Превратили в поток из ЗАРПЛАТ работников
        .mapToDouble(salary -> salary)  // Превратили в поток DOUBLE
        .average() // Среднее арифметическое
        .orElse(0.0);
  }

  static double findMaximumSalaryOfEmployeesOlderThan50( List<Employee> employees) {
    return employees.stream()
        .filter(employee -> employee.getAge() > 50) // список работников старше 50 лет
        .map(Employee::getSalary) // в поток зарплат
        .mapToDouble(salary -> salary)// в поток DOUBLE
        .max() // максимальный результат
        .orElse(0.0);
  }

  static void printAverageSalaryByAge(List<Employee> employees) {
    employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getAge, // 50
            Collectors.averagingDouble(Employee::getSalary) // 300000
            ))
        .forEach((age, salary) -> System.out.println("Average salary for age " + age + ": " + salary));
  }
}
