package com.lazarspa.customer.service;

import com.lazarspa.customer.dto.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OwnerService {

    List<OwnerDTO> findAll();
}
