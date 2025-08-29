package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.dto.DishUpdateRequest;
import com.pragma.powerup.application.handler.IDishHandler;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDish(@RequestBody @Valid DishUpdateRequest dishUpdateRequest,
                                           @PathVariable Long id) {
        dishHandler.upadateDish(dishUpdateRequest, id);
        return ResponseEntity.noContent().build();
    }
}
