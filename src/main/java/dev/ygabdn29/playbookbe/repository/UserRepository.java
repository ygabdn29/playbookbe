package dev.ygabdn29.playbookbe.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ygabdn29.playbookbe.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  User findByUsername(String username);
}