package dev.ygabdn29.playbookbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ygabdn29.playbookbe.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}