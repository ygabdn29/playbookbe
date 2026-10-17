package com.dev.ygabdn29.playbookbe.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.ygabdn29.playbookbe.entity.BacklogGame;

public interface BacklogGameRepository extends JpaRepository<BacklogGame, Integer> {
  Optional<BacklogGame> findByUserId(UUID id);
}