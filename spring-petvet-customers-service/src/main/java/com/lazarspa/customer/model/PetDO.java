package com.lazarspa.customer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.style.ToStringCreator;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PET")
public class PetDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetTypeDO type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private OwnerDO owner;

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("birthDate", this.getBirthDate())
                .append("type", this.getType().getName())
                .append("ownerFirstname", this.getOwner().getFirstName())
                .append("ownerLastname", this.getOwner().getLastName())
                .toString();
    }

    public PetDO(Integer id, String name, Date birthDate, PetTypeDO type, OwnerDO owner) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.owner = owner;
    }
}
