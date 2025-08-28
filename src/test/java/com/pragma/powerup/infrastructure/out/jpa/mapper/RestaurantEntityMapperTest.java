package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Restaurant;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantEntityMapperTest {
    private final RestaurantEntityMapper mapper = Mappers.getMapper(RestaurantEntityMapper.class);

    @Test
    void toEntity_ShouldMapDomainToEntity() {
        // Arrange
        Restaurant restaurant = new Restaurant(
                1L,
                "Restaurante Prueba",
                "123456789",
                "Calle 123",
                "+573001234567",
                "http://logo.com/logo.png",
                2L
        );

        // Act
        RestaurantEntity entity = mapper.toEntity(restaurant);

        // Assert
        assertNotNull(entity);
        assertEquals(restaurant.getId(), entity.getId());
        assertEquals(restaurant.getNombre(), entity.getNombre());
        assertEquals(restaurant.getNit(), entity.getNit());
        assertEquals(restaurant.getDireccion(), entity.getDireccion());
        assertEquals(restaurant.getTelefono(), entity.getTelefono());
        assertEquals(restaurant.getUrlLogo(), entity.getUrlLogo());
        assertEquals(restaurant.getIdPropietario(), entity.getIdPropietario());
    }

    @Test
    void toRestaurant_ShouldMapEntityToDomain() {
        // Arrange
        RestaurantEntity entity = new RestaurantEntity(
                1L,
                "Restaurante Prueba",
                "123456789",
                "Calle 123",
                "+573001234567",
                "http://logo.com/logo.png",
                2L
        );

        // Act
        Restaurant restaurant = mapper.toRestaurant(entity);

        // Assert
        assertNotNull(restaurant);
        assertEquals(entity.getId(), restaurant.getId());
        assertEquals(entity.getNombre(), restaurant.getNombre());
        assertEquals(entity.getNit(), restaurant.getNit());
        assertEquals(entity.getDireccion(), restaurant.getDireccion());
        assertEquals(entity.getTelefono(), restaurant.getTelefono());
        assertEquals(entity.getUrlLogo(), restaurant.getUrlLogo());
        assertEquals(entity.getIdPropietario(), restaurant.getIdPropietario());
    }
}