package com.dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;

@Entity
@Table(name = "tbl_m_game_library")
@NoArgsConstructor
@Setter
@Getter

public class GameLibrary {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "rawg_id", unique = true, nullable = false)
  private Integer rawgId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "slug", nullable = false)
  private String slug;

  @Column(name = "release_date")
  private LocalDate releaseDate;

  @Column(name = "developers", columnDefinition = "TEXT")
  private String developers;

  @Column(name = "publishers", columnDefinition = "TEXT")
  private String publishers;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "rating", precision = 3, scale = 2)
  private BigDecimal rating;

  @Column(name = "genres", columnDefinition = "TEXT")
  private String genres;

  @Column(name = "background_image")
  private String backgroundImage;
}