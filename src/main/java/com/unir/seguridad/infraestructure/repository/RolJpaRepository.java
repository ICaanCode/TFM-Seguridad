package com.unir.seguridad.infraestructure.repository;

import com.unir.seguridad.domain.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolJpaRepository extends JpaRepository<Rol, Integer> {}
