package kz.bitlab.G115thymeleaflayoutdialect.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
  private Long id;
  private String name;
  private String code;
}
