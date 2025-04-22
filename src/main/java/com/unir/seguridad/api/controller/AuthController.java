package com.unir.seguridad.api.controller;

import com.unir.seguridad.api.dto.AuthRequest;
import com.unir.seguridad.api.dto.AuthResponse;
import com.unir.seguridad.api.response.ApiResponse;
import com.unir.seguridad.infraestructure.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<?> autenticar(@Valid @RequestBody AuthRequest authRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
    );

    String token = jwtUtil.generateToken((UserDetails) authentication.getPrincipal());
    return ApiResponse.success(new AuthResponse(token), HttpStatus.OK);
  }

}
