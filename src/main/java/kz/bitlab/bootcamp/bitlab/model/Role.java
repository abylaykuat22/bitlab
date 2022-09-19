package kz.bitlab.bootcamp.bitlab.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
