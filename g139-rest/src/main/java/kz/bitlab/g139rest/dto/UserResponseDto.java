package kz.bitlab.g139rest.dto;

import kz.bitlab.g139rest.entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto {

    private Long id;
    private String email;
    private String fullName;
    private String gender;
}
