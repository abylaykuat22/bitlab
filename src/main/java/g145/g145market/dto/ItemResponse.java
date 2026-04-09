package g145.g145market.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemResponse {
    @JsonAlias("id")
    private Long id;

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
    private String status;

    @JsonAlias("made_in")
    private String made_in;

    @JsonAlias("created_at")
    private String createdAt;
}
