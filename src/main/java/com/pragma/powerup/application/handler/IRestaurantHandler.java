package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.RestaurantRequest;

public interface IRestaurantHandler {
    void saveRestaurant(RestaurantRequest restaurantRequest);
}
