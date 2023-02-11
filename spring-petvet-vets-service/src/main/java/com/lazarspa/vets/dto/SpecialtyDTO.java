package com.lazarspa.vets.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpecialtyDTO implements Serializable {
    private static final long serialVersionUID = 8877256636417338717L;

    private Long id;

    private String name;
}
