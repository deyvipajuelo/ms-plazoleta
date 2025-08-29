package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.handler.IDishHandler;
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
@RequestMapping("/platos")
public class DishController {

    private final IDishHandler dishHandler;

    @PostMapping("/")
    public ResponseEntity<Void> saveDish(@RequestBody @Valid DishRequest dishRequest) {
        dishHandler.saveDish(dishRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
