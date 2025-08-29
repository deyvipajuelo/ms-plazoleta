package com.pragma.powerup.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DishUpdateRequest(
        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser un valor positivo")
        Integer precio,
        @NotBlank(message = "La descripción es obligatoria")
        String descripcion
) {
}
