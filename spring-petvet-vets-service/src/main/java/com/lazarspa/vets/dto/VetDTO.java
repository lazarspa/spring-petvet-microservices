package com.lazarspa.vets.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VetDTO implements Serializable {
    private static final long serialVersionUID = 1905204142116905046L;

    private Long id;

    private String firstName;

    private String lastName;

    private List<SpecialtyDTO> specialities;
}