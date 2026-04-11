package g145.g145market.entity;

import g145.g145market.entity.base.BaseEntity;
import g145.g145market.entity.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ITEMS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item extends BaseEntity {
    @Column(name = "NAME_KZ",nullable = false)
    private String name_kz;

    @Column(name = "NAME_RU",nullable = false)
    private String name_ru;

    @Column(name = "NAME_EN",nullable = false)
    private String name_en;

    @Column(name = "PRICE",nullable = false)
    private Double price;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",nullable = false)
    private ItemStatus status; //(в наличии, нет в наличи, ожидает доставки)

    @Column(name = "MADE_IN",nullable = false)
    private String made_in;
}
