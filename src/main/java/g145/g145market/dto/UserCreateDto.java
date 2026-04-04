package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserCreateDto {

    @JsonAlias({"full_name", "name"})
    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String fullName;

    @JsonProperty("birthdate")
    @NotNull(message = "can't be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "должно соответствовать \"yyyy-MM-dd\"")
    private String birthdate;

    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String email;

    @JsonProperty("phone_number")
    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String phoneNumber;

    @JsonProperty("address")
    private String address;
}
