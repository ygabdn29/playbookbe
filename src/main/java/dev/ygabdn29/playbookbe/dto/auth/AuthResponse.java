package dev.ygabdn29.playbookbe.dto.auth;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
  private UUID id;
  private String username;
  private Boolean isDemo;
}