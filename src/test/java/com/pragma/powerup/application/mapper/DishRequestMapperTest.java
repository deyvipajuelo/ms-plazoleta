package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.domain.model.Dish;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class DishRequestMapperTest {
    private final DishRequestMapper mapper = Mappers.getMapper(DishRequestMapper.class);

    @Test
    void toDish_ShouldMapDishRequestToDish() {
        // Arrange
        DishRequest dishRequest = new DishRequest(
                "Pizza",
                15000,
                "Pizza de queso",
                "http://example.com/pizza.jpg",
                "Comida rápida",
                1L
        );

        // Act
        Dish dish = mapper.toDish(dishRequest);

        // Assert
        assertEquals(dishRequest.nombrePlato(), dish.getNombrePlato());
        assertEquals(dishRequest.precio(), dish.getPrecio());
        assertEquals(dishRequest.descripcion(), dish.getDescripcion());
        assertEquals(dishRequest.urlImagen(), dish.getUrlImagen());
        assertEquals(dishRequest.categoria(), dish.getCategoria());
    }
}