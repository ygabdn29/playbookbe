package dev.ygabdn29.playbookbe.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ygabdn29.playbookbe.common.utils.Utils;
import dev.ygabdn29.playbookbe.dto.auth.AuthResponse;
import dev.ygabdn29.playbookbe.dto.auth.LoginRequest;
import dev.ygabdn29.playbookbe.entity.User;
import dev.ygabdn29.playbookbe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final UserService userService;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody @Valid LoginRequest loginRequest, HttpServletRequest request,
      HttpServletResponse response) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        loginRequest.getUsername(), loginRequest.getPassword());
    SecurityContext securityContext = SecurityContextHolder.getContext();

    // authenticate the login request (throw error and stops here if the username or
    // password is invalid)
    var authentication = authenticationManager.authenticate(authenticationToken);

    // fetch from database to check if user exists and get the user id
    User user = userService.findByUsername(loginRequest.getUsername())
        .orElseThrow(() -> new RuntimeException("User not found"));

    // set security context to the authenticated user
    securityContext.setAuthentication(authentication);

    Boolean isDemo = user.getUsername().equals("demo");

    // persist security context to the session so that it can be used in subsequent
    // requests
    new HttpSessionSecurityContextRepository().saveContext(securityContext, request, response);

    return Utils.generateResponse(HttpStatus.OK, "Login successful",
        new AuthResponse(user.getId(),
            loginRequest.getUsername(), isDemo));
  }

}