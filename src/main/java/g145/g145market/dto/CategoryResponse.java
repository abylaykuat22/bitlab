package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name_kz")
    private String nameKz;

    @JsonProperty("name_ru")
    private String nameRu;

    @JsonProperty("name_en")
    private String nameEn;

    @JsonProperty("code")
    private String code;

    @JsonProperty("created_at")
    private String createdAt;

}
