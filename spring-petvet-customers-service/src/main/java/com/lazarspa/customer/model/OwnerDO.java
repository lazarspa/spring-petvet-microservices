package com.lazarspa.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "OWNER")
public class OwnerDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    @Digits(fraction = 0, integer = 12)
    private String telephone;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "owner")
    private List<PetDO> pets;

    public List<PetDO> getPets() {
        if (this.pets == null) {
            this.pets = new ArrayList<>();
        }
        PropertyComparator.sort(this.pets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(this.pets);
    }

    public void addPet(PetDO pet) {
        getPets().add(pet);
        pet.setOwner(this);
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName())
                .append("address", this.address)
                .append("city", this.city)
                .append("telephone", this.telephone)
                .append("pets",this.pets)
                .toString();
    }
}
