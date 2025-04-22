package com.unir.seguridad.infraestructure.repository;

import com.unir.seguridad.domain.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CredencialJpaRepository extends JpaRepository<Credencial, UUID> {

  public Optional<Credencial> findByUsername(String username);

}
