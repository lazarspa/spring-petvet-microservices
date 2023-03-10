package com.lazarspa.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OwnerDTO implements Serializable {
   private static final long serialVersionUID = 1905204142116905046L;

   private Integer id;

   private String firstName;

   private String lastName;

   private String address;

   private String city;

   private String telephone;

   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private List<PetDTO> pets;

}
