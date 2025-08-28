package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Restaurant;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.RestaurantEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class RestaurantJpaAdapterTest {
    @Mock
    private IRestaurantRepository restaurantRepository;

    @Mock
    private RestaurantEntityMapper restaurantEntityMapper;

    @InjectMocks
    private RestaurantJpaAdapter restaurantJpaAdapter;

    @Test
    void saveRestaurant_ShouldCallMapperAndRepository() {
        // Arrange
        Restaurant restaurant = new Restaurant();
        when(restaurantEntityMapper.toEntity(restaurant)).thenReturn(any(RestaurantEntity.class)); // Simula la entidad mapeada

        // Act
        restaurantJpaAdapter.saveRestaurant(restaurant);

        // Assert
        verify(restaurantEntityMapper, times(1)).toEntity(restaurant);
        verify(restaurantRepository, times(1)).save(any());
    }
}