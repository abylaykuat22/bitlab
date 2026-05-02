package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ChangePasswordDto {

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    @JsonProperty("current_password")
    private String currentPassword;

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    @JsonProperty("new_password")
    private String newPassword;

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    @JsonProperty("re_new_password")
    private String reNewPassword;

}
