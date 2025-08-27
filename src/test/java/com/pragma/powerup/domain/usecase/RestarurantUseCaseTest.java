package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Restaurant;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class RestarurantUseCaseTest {

    @Mock
    private IRestaurantPersistencePort restaurantPersistencePort;

    @InjectMocks
    private RestarurantUseCase restarurantUseCase;

    @Test
    void saveRestaurant_ShouldCallPersistencePort() {
        // Arrange
        Restaurant restaurant = new Restaurant(1L,"Restaurante A", "123456", "Calle 123", "123456789", "logo.png", "1");

        // Act
        restarurantUseCase.saveRestaurant(restaurant);

        // Assert
        verify(restaurantPersistencePort, times(1)).saveRestaurant(restaurant);
    }
}