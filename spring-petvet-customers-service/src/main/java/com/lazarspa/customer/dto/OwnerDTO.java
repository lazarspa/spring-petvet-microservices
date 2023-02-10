package com.lazarspa.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OwnerDTO implements Serializable {
   private static final long serialVersionUID = 1905204142116905046L;

   private Long id;

   private String name;

   private String surname;

   private String address;

   private String city;

   private String telephone;

   private Set<PetDTO> pets;

}
