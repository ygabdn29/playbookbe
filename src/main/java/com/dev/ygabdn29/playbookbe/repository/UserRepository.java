package com.dev.ygabdn29.playbookbe.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.ygabdn29.playbookbe.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
  Optional<User> findByUsername(String username);
}