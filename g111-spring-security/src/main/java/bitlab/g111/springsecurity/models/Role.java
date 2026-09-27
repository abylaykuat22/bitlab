package bitlab.g111.springsecurity.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
public class Role extends BaseEntity implements GrantedAuthority {
  @Column(name = "name")
  private String name;

  @Override
  public String getAuthority() {
    return name;
  }
}
