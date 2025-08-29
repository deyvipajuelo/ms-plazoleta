package com.pragma.powerup.infrastructure.input.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.powerup.application.dto.RestaurantRequest;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private IRestaurantHandler restaurantHandler;

    @Test
    void saveRestaurant_ShouldReturnCreatedStatus() throws Exception {
        // Arrange
        RestaurantRequest restaurantRequest = new RestaurantRequest(
                "Restaurante A",
                "123456789",
                "Calle 123",
                "+123456789",
                "http://example.com/logo.jpg",
                1L
        );
        doNothing().when(restaurantHandler).saveRestaurant(restaurantRequest);

        // Act & Assert
        mockMvc.perform(post("/restaurantes/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restaurantRequest)))
                .andExpect(status().isCreated());
    }
}