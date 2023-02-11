package com.lazarspa.vets.service;

import com.lazarspa.vets.dto.VetDTO;

import java.util.List;

public interface VetService {

    List<VetDTO> findAll();
}
