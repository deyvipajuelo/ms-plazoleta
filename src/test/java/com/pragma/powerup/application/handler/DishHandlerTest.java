package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.dto.DishUpdateRequest;
import com.pragma.powerup.application.mapper.DishRequestMapper;
import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.model.Dish;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class DishHandlerTest {
    @Mock
    private IDishServicePort dishServicePort;

    @Mock
    private DishRequestMapper dishRequestMapper;

    @InjectMocks
    private DishHandler dishHandler;

    @Test
    void saveDish_ShouldCallMapperAndService() {
        // Arrange
        DishRequest dishRequest = new DishRequest("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", 1L);
        Dish dish = new Dish("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);

        when(dishRequestMapper.toDish(dishRequest)).thenReturn(dish);

        // Act
        dishHandler.saveDish(dishRequest);

        // Assert
        verify(dishRequestMapper, times(1)).toDish(dishRequest);
        verify(dishServicePort, times(1)).saveDish(dish);
    }

    @Test
    void upadateDish_ShouldUpdateDishDetails() {
        // Arrange
        Long idDish = 1L;
        DishUpdateRequest dishUpdateRequest = new DishUpdateRequest(20000, "Pizza con más queso");
        Dish existingDish = new Dish("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, idDish);

        when(dishServicePort.getDishById(idDish)).thenReturn(existingDish);

        // Act
        dishHandler.upadateDish(dishUpdateRequest, idDish);

        // Assert
        verify(dishServicePort, times(1)).getDishById(idDish);
        verify(dishServicePort, times(1)).updateDish(existingDish);
        assert existingDish.getDescripcion().equals(dishUpdateRequest.descripcion());
        assert existingDish.getPrecio().equals(dishUpdateRequest.precio());
    }
}