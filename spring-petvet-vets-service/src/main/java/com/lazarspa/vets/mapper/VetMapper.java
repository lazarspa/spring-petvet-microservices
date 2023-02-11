package com.lazarspa.vets.mapper;

import com.lazarspa.vets.dto.SpecialtyDTO;
import com.lazarspa.vets.dto.VetDTO;
import com.lazarspa.vets.model.SpecialtyDO;
import com.lazarspa.vets.model.VetDO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface VetMapper {

    @Named("toDto")
    @Mapping(target = "specialties",source = "entity",qualifiedByName = "getSpecialtyDtoList")
    VetDTO toDto(VetDO entity);

    @Named("toEntity")
    @Mapping(source = "dto",target = "specialties", qualifiedByName = "getSpecialtyEntitySet")
    VetDO toEntity(VetDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<VetDTO> toDtoList(List<VetDO> entityList);

    @IterableMapping(qualifiedByName = "toEntity")
    List<VetDO> toEntityList(List<VetDTO> dtoList);

    @Named("getSpecialtyDtoList")
    default List<SpecialtyDTO> getSpecialtyDtoList(VetDO entity){
        return entity.getSpecialties().stream()
                .map(spec -> SpecialtyDTO.builder()
                        .id(spec.getId())
                        .name(spec.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Named("getSpecialtyEntitySet")
    default Set<SpecialtyDO> getSpecialtyEntitySet(VetDTO dto){
        return dto.getSpecialties().stream()
                .map(spec -> SpecialtyDO.builder()
                        .id(spec.getId())
                        .name(spec.getName())
                        .build())
                .collect(Collectors.toSet());
    }

}
