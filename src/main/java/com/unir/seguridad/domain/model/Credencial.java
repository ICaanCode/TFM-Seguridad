package com.unir.seguridad.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "usuario", name = "credencial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Credencial {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_credencial", columnDefinition = "UUID")
  private String idCredencial;

  @OneToOne
  @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario", nullable = false)
  private Usuario usuario;

  @Column(name = "username", nullable = false, unique = true, length = 50)
  private String username;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(name = "activo", nullable = false)
  private Boolean activo;

  @Column(name = "fecha_creacion",  nullable = false, updatable = false)
  private LocalDateTime fechaCreacion;

  @Column(name = "fecha_modificacion")
  private LocalDateTime fechaModificacion;

  @PrePersist
  protected void onCreate() {
    fechaCreacion = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    fechaModificacion = LocalDateTime.now();
  }

}
