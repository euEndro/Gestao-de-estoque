package group.dl.backend.application.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import group.dl.backend.application.store.mapper.StoreMapper;
import group.dl.backend.application.user.dto.UserResponseDTO;
import group.dl.backend.application.user.mapper.UserMapper;
import group.dl.backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public List<UserResponseDTO> findAll() {
    return userRepository.findAll().stream()
        .map(userMapper::toResponse)
        .toList();
  }
}
