package dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

import jakarta.persistence.Column;

@Entity
@Table(name = "tbl_tr_price")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "original_price")
  private Integer originalPrice;

  @Column(name = "discounted_price")
  private Integer discountedPrice;

  @Column(name = "discount_percentage")
  private Integer discountPercentage;

  @Column(name = "date")
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "steam_app_id", referencedColumnName = "steam_app_id")
  private GameLibrary gameLibrary;
}