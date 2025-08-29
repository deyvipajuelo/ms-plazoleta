package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Dish;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.DishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class DishJpaAdapterTest {
    @Mock
    private IDishRepository dishRepository;

    @Mock
    private DishEntityMapper dishEntityMapper;

    @InjectMocks
    private DishJpaAdapter dishJpaAdapter;

    @Test
    void saveDish_ShouldCallRepositorySave() {
        // Arrange
        Dish dish = new Dish("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);
        DishEntity dishEntity = new DishEntity(1L, "Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);

        when(dishEntityMapper.toEntity(dish)).thenReturn(dishEntity);

        // Act
        dishJpaAdapter.saveDish(dish);

        // Assert
        verify(dishEntityMapper, times(1)).toEntity(dish);
        verify(dishRepository, times(1)).save(dishEntity);
    }
}