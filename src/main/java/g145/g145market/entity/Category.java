package g145.g145market.entity;

import g145.g145market.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="CATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Category extends BaseEntity {
    @Column(name="NAME_KZ", length = 100, nullable = false)
    private String nameKz;
    @Column(name="NAME_RU", length = 100, nullable = false)
    private String nameRu;
    @Column(name="NAME_EN", length = 100, nullable = false)
    private String nameEn;
    @Column(name="CODE", nullable = false, unique = true,length = 30)
    private String code;

}
