package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Dish;
import com.pragma.powerup.domain.spi.IDishPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class DishUseCaseTest {
    @Mock
    private IDishPersistencePort dishPersistencePort;

    @InjectMocks
    private DishUseCase dishUseCase;

    @Test
    void saveDish_ShouldCallPersistencePort() {
        // Arrange
        Dish dish = new Dish("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);

        // Act
        dishUseCase.saveDish(dish);

        // Assert
        verify(dishPersistencePort, times(1)).saveDish(dish);
    }

    @Test
    void updateDish_ShouldCallPersistencePort() {
        // Arrange
        Dish dish = new Dish("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);

        // Act
        dishUseCase.updateDish(dish);

        // Assert
        verify(dishPersistencePort, times(1)).updateDish(dish);
    }
}