package com.lazarspa.vets.mapper;

import com.lazarspa.vets.dto.VetDTO;
import com.lazarspa.vets.model.VetDO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VetMapper {

    @Named("toDto")
    @Mapping(source = "id",target = "id")
    @Mapping(source = "firstName",target = "firstName")
    VetDTO toDto(VetDO entity);
    @Named("toEntity")
    VetDO toEntity(VetDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<VetDTO> toDtoList(List<VetDO> entityList);

    @IterableMapping(qualifiedByName = "toEntity")
    List<VetDO> toEntityList(List<VetDTO> dtoList);
}
