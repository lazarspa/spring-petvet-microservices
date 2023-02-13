package com.lazarspa.vets.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VetDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private List<SpecialtyDTO> specialties;

}