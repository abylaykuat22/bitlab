package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import g145.g145market.entity.enums.ItemStatus;
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
    private String name_kz;

    @JsonAlias("name_ru")
    private String name_ru;

    @JsonAlias("name_en")
    private String name_en;

    @JsonAlias("price")
    private Double price;

    @JsonAlias("amount")
    private Integer amount;

    @JsonAlias("status")
    private ItemStatus status;//(в наличии, нет в наличи, ожидает доставки)

    @JsonAlias("made_in")
    private String made_in;

}
