package dev.ygabdn29.playbookbe.service.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ygabdn29.playbookbe.entity.User;
import dev.ygabdn29.playbookbe.service.UserService;
import lombok.RequiredArgsConstructor;
import dev.ygabdn29.playbookbe.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public User getById(UUID id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public Boolean save(User entity) {
    userRepository.save(entity);
    return userRepository.findById(entity.getId()).isPresent();
  }

  @Override
  public Boolean delete(UUID id) {
    userRepository.deleteById(id);
    return userRepository.findById(id).isEmpty();
  }

}