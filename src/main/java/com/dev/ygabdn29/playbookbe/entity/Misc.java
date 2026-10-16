package com.dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "tbl_m_misc")
@NoArgsConstructor
@Setter
@Getter

public class Misc {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "misc_key")
  private String miscKey;

  @Column(name = "misc_value")
  private String miscValue;
}