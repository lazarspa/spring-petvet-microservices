package com.lazarspa.customer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class PetTypeDTO implements Serializable {
    private static final long serialVersionUID = -4320781760465248346L;

    @NotNull
    private Integer id;

    private String name;
}
