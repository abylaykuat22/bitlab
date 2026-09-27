package kz.bitlab.g128springrestapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEdit {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String rePassword;
    private Integer age;
    private Integer exam;
}
