package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.RestaurantRequest;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurantes")
public class RestaurantController {

    private final IRestaurantHandler restaurantHandler;

    @PostMapping("/propietarios")
    public ResponseEntity<Void> saveRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {
        restaurantHandler.saveRestaurant(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
