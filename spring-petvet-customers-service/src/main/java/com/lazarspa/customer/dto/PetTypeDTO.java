package com.lazarspa.customer.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class PetTypeDTO implements Serializable {
    private static final long serialVersionUID = -4320781760465248346L;

    private Integer id;

    private String name;
}
