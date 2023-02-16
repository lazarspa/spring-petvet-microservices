package com.lazarspa.customer.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PetDTO implements Serializable {
    private static final long serialVersionUID = 8163918629353302314L;

    private Integer id;

    @NotBlank
    private String name;

    @Past
    private Date birthDate;

    @Valid
    private PetTypeDTO type;
}