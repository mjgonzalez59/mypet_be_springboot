package com.mypet.mypet_be_springboot.controllers;

import com.mypet.mypet_be_springboot.exceptions.OwnerNotFoundException;
import com.mypet.mypet_be_springboot.models.OwnerModel;
import com.mypet.mypet_be_springboot.repositories.OwnerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    @PostMapping("/owner/")
    OwnerModel ownerCreate(@RequestBody OwnerModel owner){
        return ownerRepository.save(owner) ;
    }

    @GetMapping("/owner/{ownerId}/")
    OwnerModel ownerDetail(@PathVariable String ownerId){
        return ownerRepository.findById(ownerId).orElseThrow( ()-> new OwnerNotFoundException("Propetario no encontrado con cédula: "+ ownerId) );
    }


    @DeleteMapping("/owner/delete/{ownerId}/")
    String ownerDelete(@PathVariable String ownerId){
        OwnerModel ownerToDelete = ownerRepository.findById(ownerId).orElse(null);
        if(ownerToDelete == null){
            throw new OwnerNotFoundException("Propietario no encontrado.");
        }
        ownerRepository.deleteById(ownerId);
        return "Propietario borrado.";
    }

    @PostMapping("/owner/update/")
    OwnerModel ownerUpdate(@RequestBody OwnerModel ownerIncomingData){
        OwnerModel ownerToUpdate = ownerRepository.findById(ownerIncomingData.getIdOwner()).orElse(null);
        if(ownerToUpdate == null){
            throw new OwnerNotFoundException("Propietario no encontrado.");
        }

        if(ownerIncomingData.getName() != null){
            ownerToUpdate.setName(ownerIncomingData.getName());
        }
        if(ownerIncomingData.getPhone() != null){
            ownerToUpdate.setPhone(ownerIncomingData.getPhone());
        }
        if(ownerIncomingData.getEmail() != null){
            ownerToUpdate.setEmail(ownerIncomingData.getEmail());
        }
        return ownerRepository.save(ownerToUpdate);
    }

}


