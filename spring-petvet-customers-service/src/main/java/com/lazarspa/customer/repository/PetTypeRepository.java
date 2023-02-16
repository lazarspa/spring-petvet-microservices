package com.lazarspa.customer.repository;

import com.lazarspa.customer.model.PetTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetTypeDO,Integer> {
}
