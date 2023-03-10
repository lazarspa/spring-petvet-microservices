package com.lazarspa.vets.service;

import com.lazarspa.vets.dto.VetDTO;
import com.lazarspa.vets.mapper.VetMapper;
import com.lazarspa.vets.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetServiceImpl implements VetService{

    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private VetMapper vetMapper;

    @Override
    public List<VetDTO> findAll() {
        return vetMapper.toDtoList(
                vetRepository.findAll());
    }
}
