package group.dl.backend.application.auth;

public record AuthenticationDTO(
    String email,
    String password) {
}
