package com.lazarspa.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetTypeDTO implements Serializable {
    private static final long serialVersionUID = -4320781760465248346L;

    private Long id;

    private String name;
}
