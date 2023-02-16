package com.lazarspa.customer.service;

import com.lazarspa.customer.dto.OperationResult;
import com.lazarspa.customer.dto.OwnerDTO;
import com.lazarspa.customer.dto.PetDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OwnerService {

    List<OwnerDTO> findAll();

    OperationResult save(OwnerDTO owner);

    OperationResult addPet(PetDTO petRequest,Integer ownerId);
}
