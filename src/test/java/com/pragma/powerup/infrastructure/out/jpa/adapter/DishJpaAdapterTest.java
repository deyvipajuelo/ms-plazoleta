package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Dish;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.DishEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.IDishRepository;
import org.junit.jupiter.api.BeforeEach;
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

    private Dish dish;
    private DishEntity dishEntity;

    @BeforeEach
    void setUp() {
        dish = new Dish("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);
        dishEntity = new DishEntity(1L, "Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", true, 1L);
    }

    @Test
    void saveDish_ShouldCallRepositorySave() {
        // Arrange
        when(dishEntityMapper.toEntity(dish)).thenReturn(dishEntity);

        // Act
        dishJpaAdapter.saveDish(dish);

        // Assert
        verify(dishEntityMapper, times(1)).toEntity(dish);
        verify(dishRepository, times(1)).save(dishEntity);
    }

    @Test
    void updateDish_ShouldCallRepositorySave() {
        // Arrange
        when(dishEntityMapper.toEntity(dish)).thenReturn(dishEntity);

        // Act
        dishJpaAdapter.updateDish(dish);

        // Assert
        verify(dishEntityMapper, times(1)).toEntity(dish);
        verify(dishRepository, times(1)).save(dishEntity);
    }
}