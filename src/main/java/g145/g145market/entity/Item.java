package g145.g145market.entity;

import g145.g145market.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name = "STATUS",nullable = false)
    private String status; //(в наличии, нет в наличи, ожидает доставки)

    @Column(name = "MADE_IN",nullable = false)
    private String made_in;
}
