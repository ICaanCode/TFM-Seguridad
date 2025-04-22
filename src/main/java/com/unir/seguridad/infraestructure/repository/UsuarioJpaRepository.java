package com.unir.seguridad.infraestructure.repository;

import com.unir.seguridad.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, UUID> {}

