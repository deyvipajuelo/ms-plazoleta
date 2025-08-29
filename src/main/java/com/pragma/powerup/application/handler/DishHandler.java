package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.dto.DishUpdateRequest;
import com.pragma.powerup.application.mapper.DishRequestMapper;
import com.pragma.powerup.domain.api.IDishServicePort;
import com.pragma.powerup.domain.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DishHandler implements IDishHandler {
    private final IDishServicePort dishServicePort;
    private final DishRequestMapper dishRequestMapper;
    @Override
    public void saveDish(DishRequest dishRequest) {
        Dish dish = dishRequestMapper.toDish(dishRequest);
        dish.setActive(true);
        dishServicePort.saveDish(dish);
    }

    @Override
    public void upadateDish(DishUpdateRequest dishUpdateRequest, Long idDish) {
        Dish dish = dishServicePort.getDishById(idDish);
        dish.setDescripcion(dishUpdateRequest.descripcion());
        dish.setPrecio(dishUpdateRequest.precio());
        dishServicePort.updateDish(dish);
    }
}
