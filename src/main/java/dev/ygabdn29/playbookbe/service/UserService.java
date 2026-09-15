package dev.ygabdn29.playbookbe.service;

import java.util.Optional;
import java.util.UUID;

import dev.ygabdn29.playbookbe.entity.User;
import dev.ygabdn29.playbookbe.service.generic.GenericService;

public interface UserService extends GenericService<User, UUID> {
  Optional<User> findByUsername(String username);

}