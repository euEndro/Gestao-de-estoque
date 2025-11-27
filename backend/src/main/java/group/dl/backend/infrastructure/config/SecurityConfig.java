package group.dl.backend.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize

            // STORES
            .requestMatchers(HttpMethod.POST, "/api/stores").hasRole("ADMIN, MANAGER")
            .requestMatchers(HttpMethod.GET, "/api/stores").hasRole("ADMIN")
            .requestMatchers(HttpMethod.GET, "/api/stores/*").hasRole("ADMIN, MANAGER, USER")
            .requestMatchers(HttpMethod.PATCH, "/api/stores/*").hasRole("ADMIN, MANAGER")
            .requestMatchers(HttpMethod.DELETE, "/api/stores/*").hasRole("ADMIN, MANAGER")

            // USERS
            .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN"))

        .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
      throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
