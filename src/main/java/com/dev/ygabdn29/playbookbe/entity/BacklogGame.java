package com.dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
@Table(name = "tbl_tr_game", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "user_id", "game_id" }, name = "uk_tbl_tr_game_user_game") })
@NoArgsConstructor
@Setter
@Getter

public class BacklogGame {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private GameStatus status;

  @Column(name = "notes", columnDefinition = "TEXT")
  private String notes;

  @Enumerated(EnumType.STRING)
  @Column(name = "store_owned")
  private GameStore storeOwned;

  @Column(name = "store_note")
  private String storeNote;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "game_id", nullable = false)
  private GameLibrary gameLibrary;
}