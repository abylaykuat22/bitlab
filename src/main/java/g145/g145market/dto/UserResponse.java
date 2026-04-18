package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String number;

    @JsonProperty("address")
    private String address;

    @JsonProperty("created_at")
    private String createdAt;
}
