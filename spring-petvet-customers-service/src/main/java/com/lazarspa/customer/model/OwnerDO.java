package com.lazarspa.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OWNER")
public class OwnerDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    @Digits(fraction = 0,integer = 12)
    private String telephone;

    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PetDO> pets;


    protected Set<PetDO> getPetsInternal() {
        if (this.pets == null) {
            this.pets = new HashSet<>();
        }
        return this.pets;
    }

    public List<PetDO> getPets() {
        final List<PetDO> sortedPets = new ArrayList<>(getPetsInternal());
        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPets);
    }

    public void addPet(PetDO pet) {
        getPetsInternal().add(pet);
        pet.setOwner(this);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId())
                .append("lastName", this.getSurname())
                .append("firstName", this.getName())
                .append("address", this.address)
                .append("city", this.city)
                .append("telephone", this.telephone)
                .toString();
    }
}
