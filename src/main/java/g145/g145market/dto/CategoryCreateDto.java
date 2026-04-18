package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryCreateDto {

    @JsonAlias({"name_kz","nameKz"})
    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String namekz;

    @JsonAlias({"name_ru","nameRu"})
    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String nameRu;

    @JsonAlias({"name_en","nameEn"})
    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String nameEn;


    @NotNull(message = "can't be null")
    @NotBlank(message = "can't be blank")
    private String code;
}
