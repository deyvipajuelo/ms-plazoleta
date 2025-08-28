package com.pragma.powerup.application.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRequestTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidRestaurantRequest() {
        RestaurantRequest request = new RestaurantRequest(
                "Restaurante Prueba",
                "123456789",
                "Calle 123",
                "+573001234567",
                "http://logo.com/logo.png",
                1L
        );

        Set<ConstraintViolation<RestaurantRequest>> violations = validator.validate(request);
        assertEquals(0, violations.size(), "No debería haber violaciones de validación");
    }

    @Test
    void testNombreCannotBeBlank() {
        RestaurantRequest request = new RestaurantRequest(
                "",
                "123456789",
                "Calle 123",
                "+573001234567",
                "http://logo.com/logo.png",
                1L
        );

        Set<ConstraintViolation<RestaurantRequest>> violations = validator.validate(request);
        assertEquals(2, violations.size(), "Debe haber exactamente dos violaciones de validación para el campo 'nombre'");
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El nombre es obligatorio")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El nombre no puede contener solo números")));
    }

    @Test
    void testNitMustContainOnlyNumbers() {
        RestaurantRequest request = new RestaurantRequest(
                "Restaurante Prueba",
                "123A",
                "Calle 123",
                "+573001234567",
                "http://logo.com/logo.png",
                1L
        );

        Set<ConstraintViolation<RestaurantRequest>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("El NIT solo puede contener números", violations.iterator().next().getMessage());
    }

    @Test
    void testTelefonoInvalidFormat() {
        RestaurantRequest request = new RestaurantRequest(
                "Restaurante Prueba",
                "123456789",
                "Calle 123",
                "telefono_invalido",
                "http://logo.com/logo.png",
                1L
        );

        Set<ConstraintViolation<RestaurantRequest>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("El telefono solo puede contener números, con máximo 13 caracteres", violations.iterator().next().getMessage());
    }
}