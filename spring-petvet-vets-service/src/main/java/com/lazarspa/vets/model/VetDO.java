package com.lazarspa.vets.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import java.util.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "VET")
public class VetDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "VET_SPECIALTIES", joinColumns = @JoinColumn(name="vet_id"),
    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<SpecialtyDO> specialties;

    protected Set<SpecialtyDO> getSpecialtiesInternal(){
        if(specialties == null)
            specialties = new HashSet<>();

        return this.specialties;
    }
    public List<SpecialtyDO> getSpecialties (){
        List<SpecialtyDO> sortedSpec = new ArrayList<>(getSpecialtiesInternal());
        PropertyComparator.sort(sortedSpec, new MutableSortDefinition("name",true,true));
        return Collections.unmodifiableList(sortedSpec);
    }

    public void setSpecialties(Set<SpecialtyDO> specialties) {
        this.specialties = specialties;
    }

    public int getNrOfSpecialties() {
        return getSpecialtiesInternal().size();
    }

    public void addSpecialty(SpecialtyDO specialty) {
        getSpecialtiesInternal().add(specialty);
    }

}
