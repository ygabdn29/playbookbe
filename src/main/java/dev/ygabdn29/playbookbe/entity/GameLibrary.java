package dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_m_game_library")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GameLibrary {
  @Id
  @Column(name = "steam_app_id")
  private Integer steamAppId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "developer")
  private String developer;

  @Column(name = "publisher")
  private String publisher;

}
