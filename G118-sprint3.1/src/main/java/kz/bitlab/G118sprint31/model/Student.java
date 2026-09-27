package kz.bitlab.G118sprint31.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {
  private Long id;
  private String name;
  private String surname;
  private Integer exam;
  private String mark;
}
