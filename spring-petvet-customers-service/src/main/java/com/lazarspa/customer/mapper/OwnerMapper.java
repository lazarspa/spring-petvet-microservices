package com.lazarspa.customer.mapper;

import com.lazarspa.customer.dto.OwnerDTO;
import com.lazarspa.customer.dto.PetDTO;
import com.lazarspa.customer.dto.PetTypeDTO;
import com.lazarspa.customer.model.OwnerDO;
import com.lazarspa.customer.model.PetDO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Named("toDto")
    @Mapping(target = "pets",source="pets",qualifiedByName = "getPetsToDto")
    OwnerDTO toDto(OwnerDO entity);

    @Named("toEntity")
    OwnerDO toEntity(OwnerDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<OwnerDTO> toDtoList(List<OwnerDO> entityList);

    @IterableMapping(qualifiedByName = "toEntity")
    List<OwnerDO> toEntityList(List<OwnerDTO> dtoList);

    @Named("getPetsToDto")
    default List<PetDTO> getPetsToDto(List<PetDO> pets){
        return pets.stream().map(pet -> PetDTO.builder()
                            .id(pet.getId())
                            .name(pet.getName())
                            .birthDate(pet.getBirthDate())
                            .type(PetTypeDTO.builder()
                                    .id(pet.getType().getId())
                                    .name(pet.getType().getName()).build()
                                    )
                        .build()
                )
                .collect(Collectors.toList());
    }
}
