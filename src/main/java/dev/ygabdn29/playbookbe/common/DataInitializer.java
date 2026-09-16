package dev.ygabdn29.playbookbe.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.ygabdn29.playbookbe.entity.User;
import dev.ygabdn29.playbookbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Profile("dev")
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
  // This class can be used to initialize data in the database for development
  // purposes.
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    // Check if the demo user already exists
    if (userRepository.findByUsername("demo").isEmpty()) {
      User user = new User();
      user.setUsername("demo");
      user.setPassword(passwordEncoder.encode("demoplaybook123"));
      userRepository.save(user);
      log.info("Seeded Demo User");
    }
    if (userRepository.findByUsername("yoga").isEmpty()) {
      User user = new User();
      user.setUsername("yoga");
      user.setPassword(passwordEncoder.encode("yogaplaybook123"));
      userRepository.save(user);
      log.info("Seeded Dev Yoga User");

    }
  }

}