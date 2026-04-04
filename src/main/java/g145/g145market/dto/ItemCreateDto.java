package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemCreateDto {
    @JsonAlias("name_kz")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private String name_kz;

    @JsonAlias("name_ru")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private String name_ru;

    @JsonAlias("name_en")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private String name_en;

    @JsonAlias("price")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private Double price;

    @JsonAlias("amount")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private Integer amount;

    @JsonAlias("status")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private String status;//(в наличии, нет в наличи, ожидает доставки)

    @JsonAlias("made_in")
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be null")
    private String made_in;

}
