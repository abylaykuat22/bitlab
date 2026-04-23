package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import g145.g145market.entity.enums.ItemStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Schema(description = "Запрос на создание нового товара")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemCreateDto {

    @Schema(description = "Наименование товара на казахском языке", example = "Курт")
    @JsonAlias("name_kz")
    @NotNull(message = "Наименование товара обязательное")
    @NotBlank(message = "Наименование товара не может быть пустой строкой")
    private String name_kz;

    @Schema(description = "Наименование товара на русском языке", example = "Курт")
    @JsonAlias("name_ru")
    @NotNull(message = "Наименование товара обязательное")
    @NotBlank(message = "Наименование товара не может быть пустой строкой")
    private String name_ru;

    @Schema(description = "Наименование товара на английском языке", example = "Qurt")
    @JsonAlias("name_en")
    @NotNull(message = "Наименование товара обязательное")
    @NotBlank(message = "Наименование товара не может быть пустой строкой")
    private String name_en;

    @Schema(description = "Цена товара", example = "355.5")
    @JsonAlias("price")
    @Min(value = 1000, message = "Минимальная цена: 1000")
    @NotNull(message = "Цена обязательная")
    private Double price;

    @Schema(description = "Количество товара", example = "5")
    @JsonAlias("amount")
    private Integer amount;

    @Schema(description = "Статус товара", example = "AVAILABLE")
    @JsonAlias("status")
    @NotNull(message = "Статус обязательный")
    private ItemStatus status;//(в наличии, нет в наличи, ожидает доставки)

    @Schema(description = "Страна производитель", example = "Казахстан")
    @JsonAlias("made_in")
    @NotNull(message = "Страна производитель обязательна")
    private String made_in;

}
