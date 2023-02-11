package com.lazarspa.vets.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SpecialtyDTO implements Serializable {
    private static final long serialVersionUID = 8877256636417338717L;

    private Long id;

    private String name;
}
