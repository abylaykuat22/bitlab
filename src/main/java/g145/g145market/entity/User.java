package g145.g145market.entity;

import g145.g145market.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User extends BaseEntity implements UserDetails {

    @Column(name = "FULL_NAME", length = 100, nullable = false)
    private String fullName;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER", nullable = false, unique = true, length = 20)
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
