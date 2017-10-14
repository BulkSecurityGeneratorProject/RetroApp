package com.feedback.service.mapper;

import com.feedback.domain.Weight;
import com.feedback.service.dto.WeightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Weight and its DTO WeightDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, })
public interface WeightMapper extends EntityMapper <WeightDTO, Weight> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    WeightDTO toDto(Weight weight);

    @Mapping(source = "userId", target = "user")
    Weight toEntity(WeightDTO weightDTO);
    default Weight fromId(Long id) {
        if (id == null) {
            return null;
        }
        Weight weight = new Weight();
        weight.setId(id);
        return weight;
    }
}
