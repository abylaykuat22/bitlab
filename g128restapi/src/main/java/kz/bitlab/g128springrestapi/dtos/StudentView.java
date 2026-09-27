package kz.bitlab.g128springrestapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentView {

    private Long id;
    private String fullName;
    private String email;
    private Integer age;
    private Integer exam;
    private String mark;
}
