package com.lazarspa.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.style.ToStringCreator;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PET")
public class PetDO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Column(name ="birth_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id",nullable = false)
    private PetTypeDO type;

    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    @JsonIgnore
    private OwnerDO owner;

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("birthDate", this.getBirthDate())
                .append("type", this.getType().getName())
                .append("ownerFirstname", this.getOwner().getName())
                .append("ownerLastname", this.getOwner().getSurname())
                .toString();
    }
}
