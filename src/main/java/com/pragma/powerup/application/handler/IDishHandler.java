package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.dto.DishUpdateRequest;

public interface IDishHandler {
    void saveDish(DishRequest dishRequest);
    void upadateDish(DishUpdateRequest dishUpdateRequest, Long idDish);
}
