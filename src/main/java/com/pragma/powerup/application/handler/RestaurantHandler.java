package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.RestaurantRequest;
import com.pragma.powerup.application.mapper.RestaurantRequestMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final RestaurantRequestMapper restaurantRequestMapper;

    @Override
    public void saveRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRequestMapper.toRestaurant(restaurantRequest);
        restaurantServicePort.saveRestaurant(restaurant);
    }
}
