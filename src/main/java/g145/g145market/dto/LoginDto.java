package g145.g145market.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LoginDto {

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String email;

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String password;

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String rePassword;

}
