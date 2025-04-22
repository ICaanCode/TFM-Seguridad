package com.unir.seguridad.application.service;

import com.unir.seguridad.domain.model.Credencial;
import com.unir.seguridad.infraestructure.repository.CredencialJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final CredencialJpaRepository credencialRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Credencial credencial = credencialRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(String.format("El usuario '%s' no fue encontrado", username)));
//    return new org.springframework.security.core.userdetails.User(
    return new User(
        credencial.getUsername(),
        credencial.getPasswordHash(),
        List.of(new SimpleGrantedAuthority(credencial.getUsuario().getRol().getNombre()))
    );
  }

}
