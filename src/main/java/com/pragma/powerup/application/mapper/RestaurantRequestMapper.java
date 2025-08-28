package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.RestaurantRequest;
import com.pragma.powerup.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RestaurantRequestMapper {
    Restaurant toRestaurant(RestaurantRequest restaurantRequest);
}
