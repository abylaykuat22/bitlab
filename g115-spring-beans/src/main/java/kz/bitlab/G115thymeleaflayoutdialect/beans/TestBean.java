package kz.bitlab.G115thymeleaflayoutdialect.beans;

import org.springframework.stereotype.Component;

@Component
public class TestBean {

  public TestBean() {
    System.out.println("конструктор для класса TestBean создан");
  }

  public void welcome() {
    System.out.println("Welcome to testBean method");
  }
}
