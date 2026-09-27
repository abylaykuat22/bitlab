package models;

public class Developer {
  private Long id;
  private String name;
  private String surname;
  private String birthCity;
  private Integer age;

  public Developer(Long id, String name, String surname, String birthCity, Integer age) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.birthCity = birthCity;
    this.age = age;
  }

  public Developer() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getBirthCity() {
    return birthCity;
  }

  public void setBirthCity(String birthCity) {
    this.birthCity = birthCity;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
