package com.unir.seguridad.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {

  @NotBlank(message = "Debe proporcionar un nombre de usuario.")
  private String username;

  @NotBlank(message = "Debe proporcionar una contraseña.")
  private String password;

}
