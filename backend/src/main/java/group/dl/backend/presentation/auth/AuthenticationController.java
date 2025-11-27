package group.dl.backend.presentation.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.dl.backend.application.auth.AuthenticationDTO;
import group.dl.backend.application.auth.dto.RegisterDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

  private AuthenticationManager authenticationManager;

  public AuthenticationController(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {

    var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
    var auth = authenticationManager.authenticate(usernamePassword);

    return ResponseEntity.ok().build();
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {

  }

}
