package com.lazarspa.customer.repository;

import com.lazarspa.customer.model.OwnerDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerDO,Long> {
}
