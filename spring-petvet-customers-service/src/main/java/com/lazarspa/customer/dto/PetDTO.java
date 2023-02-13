package com.lazarspa.customer.dto;


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

    private String name;

    private Date birthDate;

    private PetTypeDTO type;
}