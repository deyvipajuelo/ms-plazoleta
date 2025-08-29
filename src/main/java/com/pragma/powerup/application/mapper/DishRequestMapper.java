package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.DishRequest;
import com.pragma.powerup.application.dto.DishUpdateRequest;
import com.pragma.powerup.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DishRequestMapper {
    Dish toDish(DishRequest dishRequest);

    @Mapping(target = "id", source = "id")
    Dish toDishUpdate(DishUpdateRequest dishUpdateRequest, Long id);
}
