package com.pragma.powerup.application.dto;

import jakarta.validation.constraints.*;
public record RestaurantRequest(
       @NotBlank(message = "El nombre es obligatorio")
       @Pattern(
               regexp = "^(?!\\d+$).+",
               message = "El nombre no puede contener solo números"
       )
       String nombre,

       @NotBlank(message = "El NIT es obligatorio")
       @Pattern(
               regexp = "^[0-9]+$",
               message = "El NIT solo puede contener números"
       )
       String nit,
       @NotBlank(message = "La dirección es obligatoria")
       String direccion,
       @NotBlank(message = "El teléfono es obligatorio")
       @Pattern(
               regexp = "^\\+?[0-9]{1,13}$",
               message = "El telefono solo puede contener números, con máximo 13 caracteres"
       )
       String telefono,
       @NotBlank(message = "La URL del logo es obligatoria")
       String urlLogo,
       @NotNull(message = "El ID del propietario es obligatorio")
       Long idPropietario
) {
}
