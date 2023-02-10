package com.lazarspa.customer.repository;

import com.lazarspa.customer.model.PetDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetDO,Long> {
}
