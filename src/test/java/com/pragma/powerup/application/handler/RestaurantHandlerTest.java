package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.RestaurantRequest;
import com.pragma.powerup.application.mapper.RestaurantRequestMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class RestaurantHandlerTest {
    @Mock
    private IRestaurantServicePort restaurantServicePort;

    @Mock
    private RestaurantRequestMapper restaurantRequestMapper;

    @InjectMocks
    private RestaurantHandler restaurantHandler;

    @Test
    void saveRestaurant_ShouldCallMapperAndService() {
        // Arrange
        RestaurantRequest restaurantRequest = new RestaurantRequest(
                "Restaurante Prueba",
                "123456789",
                "Calle 123",
                "+573001234567",
                "http://logo.com/logo.png",
                1L
        );
        Restaurant restaurant = new Restaurant();
        when(restaurantRequestMapper.toRestaurant(restaurantRequest)).thenReturn(restaurant);

        // Act
        restaurantHandler.saveRestaurant(restaurantRequest);

        // Assert
        verify(restaurantRequestMapper, times(1)).toRestaurant(restaurantRequest);
        verify(restaurantServicePort, times(1)).saveRestaurant(restaurant);
    }
}