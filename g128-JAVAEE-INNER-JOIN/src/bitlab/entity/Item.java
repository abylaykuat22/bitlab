package bitlab.entity;

public class Item {

  private Long id;
  private String name;
  private String description;
  private Double price;
  private Brand brand;

  public Item(Long id, String name, String description, Double price, Brand brand) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.brand = brand;
  }

  public Item() {

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }
}
