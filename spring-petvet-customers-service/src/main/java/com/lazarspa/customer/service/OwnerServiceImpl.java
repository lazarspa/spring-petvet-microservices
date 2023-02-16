package com.lazarspa.customer.service;


import com.lazarspa.customer.dto.OperationResult;
import com.lazarspa.customer.dto.OwnerDTO;
import com.lazarspa.customer.dto.PetDTO;
import com.lazarspa.customer.mapper.OwnerMapper;
import com.lazarspa.customer.mapper.PetMapper;
import com.lazarspa.customer.model.OwnerDO;
import com.lazarspa.customer.model.PetDO;
import com.lazarspa.customer.model.PetTypeDO;
import com.lazarspa.customer.repository.OwnerRepository;
import com.lazarspa.customer.repository.PetTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

    private final PetMapper petMapper;

    private final PetTypeRepository petTypeRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper, PetMapper petMapper, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
        this.petMapper = petMapper;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public List<OwnerDTO> findAll() {

        log.info("Fetching all owners");

        List<OwnerDO> all = ownerRepository.findAll();
        return ownerMapper.toDtoList(all);
    }

    @Override
    public OperationResult save(OwnerDTO owner) {

        OperationResult outputDTO = OperationResult.builder()
                .success(true)
                .build();

        try {
            OwnerDO ownerDO = ownerMapper.toEntity(owner);

            ownerRepository.save(ownerDO);
        }
        catch (Exception ex){
            log.error("Error executing save operation for owner",ex);
            outputDTO.setSuccess(false);
            outputDTO.getMessages().add(ex.getMessage());
        }

        return outputDTO;
    }

    @Override
    public OperationResult addPet(PetDTO petRequest, Integer ownerId) {

        log.info("Executing add pet operation");

        OperationResult<Object> outputDTO = OperationResult.builder()
                .success(true)
                .build();

        try {
            OwnerDO ownerDO = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalArgumentException("Owner with id {" + ownerId + "} does not exist"));


            Optional<PetTypeDO> petType = petTypeRepository.findById(petRequest.getType().getId());

            PetDO petDO = petMapper.toEntity(petRequest);

            petType.ifPresentOrElse(
                    petDO::setType,
                    () -> new IllegalArgumentException("Pet type with id {" + petRequest.getType().getId() + "} does not exist"));


            ownerDO.addPet(petDO);

        } catch (Exception ex) {
            outputDTO.setSuccess(false);
//            outputDTO.getMessages().add(ex.getMessage());
            log.error("Error executing add pet operation", ex);
        }

        return null;
    }
}
