package bitlab.entity;

public class Employee {

  private Long id;
  private String name;
  private String surname;
  private String department;
  private Integer salary;

  public Employee(Long id, String name, String surname, String department, Integer salary) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.department = department;
    this.salary = salary;
  }

  public Employee() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
