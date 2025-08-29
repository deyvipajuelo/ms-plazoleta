package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Restaurant;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.IUserServicePort;
import com.pragma.powerup.infrastructure.exception.UserIsNotOwnerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class RestarurantUseCaseTest {

    @Mock
    private IRestaurantPersistencePort restaurantPersistencePort;

    @Mock
    private IUserServicePort userServicePort;

    @InjectMocks
    private RestarurantUseCase restarurantUseCase;

    @Test
    void saveRestaurant_ShouldCallPersistencePort_WhenUserIsOwner() {
        // Arrange
        Restaurant restaurant = new Restaurant(1L,"Restaurante A", "123456", "Calle 123", "123456789", "logo.png", 1L);
        when(userServicePort.isOwner(restaurant.getIdPropietario())).thenReturn(true);

        // Act
        restarurantUseCase.saveRestaurant(restaurant);

        // Assert
        verify(userServicePort, times(1)).isOwner(restaurant.getIdPropietario());
        verify(restaurantPersistencePort, times(1)).saveRestaurant(restaurant);
    }

    @Test
    void saveRestaurant_ShouldThrowException_WhenUserIsNotOwner() {
        // Arrange
        Restaurant restaurant = new Restaurant(1L, "Restaurante A", "123456", "Calle 123", "123456789", "logo.png", 1L);
        when(userServicePort.isOwner(restaurant.getIdPropietario())).thenReturn(false);

        // Act & Assert
        assertThrows(UserIsNotOwnerException.class, () -> restarurantUseCase.saveRestaurant(restaurant));
        verify(userServicePort, times(1)).isOwner(restaurant.getIdPropietario());
        verify(restaurantPersistencePort, never()).saveRestaurant(any());
    }
}