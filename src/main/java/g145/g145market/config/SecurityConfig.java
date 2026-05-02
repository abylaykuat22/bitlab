package g145.g145market.config;

import g145.g145market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Отключаем, если это чисто API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/users/register").anonymous()
                        .requestMatchers("/", "/users/export").authenticated()
                        .requestMatchers("/", "/users/import").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/users/change-password").authenticated()
                        .anyRequest().permitAll()
                )
                // Включаем Basic Auth с дефолтными настройками
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                );

        return http.build();
    }
}
