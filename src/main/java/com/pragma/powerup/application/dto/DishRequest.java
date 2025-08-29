package com.pragma.powerup.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DishRequest(
        @NotBlank(message = "El nombre del plato es obligatorio")
        String nombrePlato,

        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser un valor positivo")
        Integer precio,

        @NotBlank(message = "La descripción es obligatoria")
        String descripcion,

        @NotBlank(message = "La URL de la imagen es obligatoria")
        String urlImagen,

        @NotBlank(message = "La categoría es obligatoria")
        String categoria,

        @NotNull(message = "El ID del restaurante es obligatorio")
        Long restauranteId
) {
}
