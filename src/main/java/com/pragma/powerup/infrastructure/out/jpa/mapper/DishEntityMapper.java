package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.Dish;
import com.pragma.powerup.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DishEntityMapper {
    DishEntity toEntity(Dish dish);
}
