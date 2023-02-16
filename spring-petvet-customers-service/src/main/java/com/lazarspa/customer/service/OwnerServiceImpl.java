package com.lazarspa.customer.service;


import com.lazarspa.customer.dto.OwnerDTO;
import com.lazarspa.customer.mapper.OwnerMapper;
import com.lazarspa.customer.model.OwnerDO;
import com.lazarspa.customer.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<OwnerDTO> findAll() {

        log.info("Fetching all owners");

        List<OwnerDO> all = ownerRepository.findAll();
        return ownerMapper.toDtoList(all);
    }
}
