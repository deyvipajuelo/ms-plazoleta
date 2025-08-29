package com.pragma.powerup.infrastructure.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.dto.DishUpdateRequest;
import com.pragma.powerup.application.handler.IDishHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DishController.class)
class DishControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IDishHandler dishHandler;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveRestaurant_ShouldReturnCreatedStatus() throws Exception {
        // Arrange
        DishRequest dishRequest = new DishRequest("Pizza", 15000, "Pizza de queso", "http://example.com/pizza.jpg", "Comida rápida", 1L);
        doNothing().when(dishHandler).saveDish(dishRequest);

        // Act & Assert
        mockMvc.perform(post("/platos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dishRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateDish_ShouldReturnNoContentStatus() throws Exception {
        // Arrange
        Long id = 1L;
        DishUpdateRequest dishUpdateRequest = new DishUpdateRequest(
                20000,
                "Pizza con más queso"
        );
        doNothing().when(dishHandler).upadateDish(dishUpdateRequest, id);

        // Act & Assert
        mockMvc.perform(put("/platos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dishUpdateRequest)))
                .andExpect(status().isNoContent());
    }
}