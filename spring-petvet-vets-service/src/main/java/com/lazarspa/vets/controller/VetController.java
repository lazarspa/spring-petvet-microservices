package com.lazarspa.vets.controller;

import com.lazarspa.vets.dto.VetDTO;
import com.lazarspa.vets.repository.VetRepository;
import com.lazarspa.vets.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vet")
public class VetController {

    @Autowired
    private VetService vetService;

    @GetMapping
    public List<VetDTO> findAll(){
        return vetService.findAll();
    }
}
