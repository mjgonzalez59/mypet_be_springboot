package com.mypet.mypet_be_springboot.controllers;

import com.mypet.mypet_be_springboot.exceptions.OwnerNotFoundException;
import com.mypet.mypet_be_springboot.exceptions.PetNotFoundException;
import com.mypet.mypet_be_springboot.models.OwnerModel;
import com.mypet.mypet_be_springboot.models.PetModel;
import com.mypet.mypet_be_springboot.repositories.OwnerRepository;
import com.mypet.mypet_be_springboot.repositories.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PetController {
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetController(PetRepository petRepository, OwnerRepository ownerRepository){
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    @PostMapping("/pet/")
    PetModel petCreate(@RequestBody PetModel petModel){
        return petRepository.save(petModel);
    }


    @GetMapping("/pet/{petId}/")
    PetModel petDetail(@PathVariable String petId){
        return petRepository.findById(petId).orElseThrow( ()-> new PetNotFoundException("Mascota no encontrada."));
    }


    @GetMapping("/pets/{ownerId}/")
    List<PetModel> petsWithOwner(@PathVariable String ownerId){
        OwnerModel owner = ownerRepository.findById(ownerId).orElse(null);
        if(owner == null){
            throw new OwnerNotFoundException("No se encontró el propetario con cédula: " + ownerId);
        }

        List<PetModel> petsOwner = petRepository.findByidOwner(ownerId);

        return petsOwner;
    }

    @DeleteMapping("/pet/delete/{petId}/")
    String petDelete(@PathVariable String petId){
        PetModel petToDelete = petRepository.findById(petId).orElse(null);
        if(petToDelete == null){
            throw new PetNotFoundException("Mascota no encontrada.");
        }
        petRepository.deleteById(petId);
        return "Mascota borrada.";
    }

    @PostMapping("/pet/update/")
    PetModel petUpdate(@RequestBody PetModel petIncomingData){
        PetModel petToUpdate = petRepository.findById(petIncomingData.getId()).orElse(null);
        if(petToUpdate == null){
            throw new PetNotFoundException("Mascota no encontrada.");
        }

        if(petIncomingData.getName() != null){
            petToUpdate.setName(petIncomingData.getName());
        }
        if(petIncomingData.getType() != null){
            petToUpdate.setType(petIncomingData.getType());
        }
        if(petIncomingData.getBreed() != null){
            petToUpdate.setBreed(petIncomingData.getBreed());
        }
        if(petIncomingData.getGender() != null){
            petToUpdate.setGender(petIncomingData.getGender());
        }
        if(petIncomingData.getWeight() != 0){
            petToUpdate.setWeight(petIncomingData.getWeight());
        }
        if(petIncomingData.getSize() != 0){
            petToUpdate.setSize(petIncomingData.getSize());
        }
        if(petIncomingData.getBirthDate() != null){
            petToUpdate.setBirthDate(petIncomingData.getBirthDate());
        }

        return petRepository.save(petToUpdate);
    }

}


