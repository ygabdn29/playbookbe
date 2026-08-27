package dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tr_game")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Game {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private GameStatus status;

  @Column(name = "is_owned")
  private Boolean isOwned;

  @Column(name = "play_time")
  private Integer playTime;

  @Column(name = "achievements")
  private Integer achievements;

  @Column(name = "notes", columnDefinition = "TEXT")
  private String notes;

  @Column(name = "sale_is_notified")
  private Boolean saleIsNotified;

  @Column(name = "is_deleted")
  private Boolean isDeleted;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "steam_app_id", referencedColumnName = "steam_app_id")
  private GameLibrary gameLibrary;

}
