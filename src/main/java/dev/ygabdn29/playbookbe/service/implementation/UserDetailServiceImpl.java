package dev.ygabdn29.playbookbe.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.ygabdn29.playbookbe.entity.User;
import dev.ygabdn29.playbookbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  // This method is used by Spring Security to load a user by username. It is used
  // for authentication.
  // A separate service is used for this purpose because the UserServiceImpl is
  // used for CRUD operations and not for authentication.
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    // User here is from spring security, not the entity User. So we need to convert
    // the entity User to the spring security User.
    return new org.springframework.security.core.userdetails.User(
        user.get().getUsername(),
        user.get().getPassword(),
        // Current workaround since no roles are implemented yet, so all users will have
        // ROLE_USER
        List.of(new SimpleGrantedAuthority("ROLE_USER")));
  }

}