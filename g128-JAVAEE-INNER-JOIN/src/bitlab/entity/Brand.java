package bitlab.entity;

public class Brand {

  private Long id;
  private String name;
  private String shortName;
  private String country;

  public Brand(Long id, String name, String shortName, String country) {
    this.id = id;
    this.name = name;
    this.shortName = shortName;
    this.country = country;
  }

  public Brand() {

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

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
