package kz.bitlab.g128springrestapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentCreate {

    private String name;
    private String email;
    private String password;
    private String rePassword;
    private Integer age;
    private Integer exam;
}
