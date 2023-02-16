package com.lazarspa.customer.mapper;

import com.lazarspa.customer.dto.PetDTO;
import com.lazarspa.customer.model.PetDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
@Mapper(componentModel = "spring")
public interface PetMapper {

    @Named("toDto")
    PetDTO toDto(PetDO entity);

    @Named("toEntity")
    PetDO toEntity(PetDTO dto);

}
