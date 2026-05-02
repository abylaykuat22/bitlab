package g145.g145market.entity;

import g145.g145market.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ROLES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Override
    public String getAuthority() {
        return name;
    }
}
