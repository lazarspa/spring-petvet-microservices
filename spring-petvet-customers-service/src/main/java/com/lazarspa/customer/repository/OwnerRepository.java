package com.lazarspa.customer.repository;

import com.lazarspa.customer.model.OwnerDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerDO,Long> {
}
