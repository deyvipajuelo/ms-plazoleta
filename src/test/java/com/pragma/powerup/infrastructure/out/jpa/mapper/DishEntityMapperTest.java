package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Dish;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class DishEntityMapperTest {

    private final DishEntityMapper mapper = Mappers.getMapper(DishEntityMapper.class);

    @Test
    void toEntity_ShouldMapDishToDishEntity() {
        // Arrange
        Dish dish = new Dish(

                "Pizza",
                15000,
                "Pizza de queso",
                "http://example.com/pizza.jpg",
                "Comida rápida",
                true,
                1L
        );

        // Act
        DishEntity dishEntity = mapper.toEntity(dish);

        // Assert
        assertEquals(dish.getNombrePlato(), dishEntity.getNombrePlato());
        assertEquals(dish.getPrecio(), dishEntity.getPrecio());
        assertEquals(dish.getDescripcion(), dishEntity.getDescripcion());
        assertEquals(dish.getUrlImagen(), dishEntity.getUrlImagen());
        assertEquals(dish.getCategoria(), dishEntity.getCategoria());
        assertEquals(dish.isActive(), dishEntity.isActive());
        assertEquals(dish.getRestaurantId(), dishEntity.getRestauranteId());
    }

}