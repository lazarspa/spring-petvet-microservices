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
public class PetDTO implements Serializable {
    private static final long serialVersionUID = 8163918629353302314L;

    private Long id;

    private String name;

    private PetTypeDTO type;
}