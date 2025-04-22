package com.unir.seguridad.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "usuario", name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_usuario", columnDefinition = "UUID")
  private UUID idUsuario;

  @Column(name = "nombres", nullable = false, length = 100)
  private String nombres;

  @Column(name = "apellidos", nullable = false, length = 100)
  private String apellidos;

  @Column(name = "email",  nullable = false, unique = true, length = 150)
  private String email;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rol_id", referencedColumnName = "id_rol", foreignKey = @ForeignKey(name = "fk_usuario_rol"))
  private Rol rol;

  @Column(name = "fecha_creacion", nullable = false)
  private LocalDateTime fechaCreacion;

  @Column(name = "fecha_modificacion")
  private LocalDateTime fechaModificacion;

  @PrePersist
  public void onCreate() {
    this.fechaCreacion = LocalDateTime.now();
  }

  @PreUpdate
  public void onUpdate() {
    this.fechaModificacion = LocalDateTime.now();
  }

}
