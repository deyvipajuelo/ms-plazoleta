package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Dish;

public interface IDishServicePort {
    void saveDish(Dish dish);
}
