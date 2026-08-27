package dev.ygabdn29.playbookbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ygabdn29.playbookbe.entity.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}