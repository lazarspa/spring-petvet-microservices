package com.lazarspa.vets.repository;

import com.lazarspa.vets.model.VetDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<VetDO,Long> {
}
