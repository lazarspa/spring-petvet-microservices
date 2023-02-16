package com.lazarspa.customer.controller;

import com.lazarspa.customer.dto.OperationResult;
import com.lazarspa.customer.dto.OwnerDTO;
import com.lazarspa.customer.dto.PetDTO;
import com.lazarspa.customer.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/owner")
    public OperationResult saveOwner(@RequestBody OwnerDTO owner){
        return ownerService.save(owner);
    }

    @PostMapping("/owner/{id}/pet")
    public OperationResult addPet(@RequestBody PetDTO petRequest, @PathVariable Integer id){
       return ownerService.addPet(petRequest,id);
    }
    @GetMapping("/owner")
    public List<OwnerDTO> findAll(){
        return ownerService.findAll();
    }



}
