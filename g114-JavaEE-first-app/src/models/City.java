package models;

public class City {
  private Long id;
  private String name;
  private String code;
  private Street street;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Street getStreet() {
    return street;
  }

  public void setStreet(Street street) {
    this.street = street;
  }
}
