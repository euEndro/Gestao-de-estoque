package group.dl.backend.domain.user;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

  ADMIN(List.of(
      new SimpleGrantedAuthority("ROLE_ADMIN"))),

  MANAGER(List.of(
      new SimpleGrantedAuthority("ROLE_MANAGER"))),

  USER(List.of(
      new SimpleGrantedAuthority("ROLE_USER")));

  private final List<GrantedAuthority> authorities;

  Role(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  public List<GrantedAuthority> getAuthorities() {
    return authorities;
  }
}
