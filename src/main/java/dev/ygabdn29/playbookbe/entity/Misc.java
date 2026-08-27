package dev.ygabdn29.playbookbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "tbl_m_misc")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Misc {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "misc_name")
  private String miscName;

  @Column(name = "misc_values")
  private String miscValues;

}