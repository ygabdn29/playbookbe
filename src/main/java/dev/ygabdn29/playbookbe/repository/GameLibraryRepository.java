package dev.ygabdn29.playbookbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ygabdn29.playbookbe.entity.GameLibrary;

public interface GameLibraryRepository extends JpaRepository<GameLibrary, Integer> {

}