package com.unir.seguridad.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rol", schema = "catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rol", updatable = false, nullable = false)
  private Integer id;

  @Column(name = "nombre", nullable = false, unique = true, length = 50)
  private String nombre;

  @Column(name = "codigo", nullable = false, unique = true)
  private Integer codigo;

  @Column(name = "activo", nullable = false)
  private Boolean activo;

  @Column(name = "fecha_creacion", nullable = false, updatable = false)
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
