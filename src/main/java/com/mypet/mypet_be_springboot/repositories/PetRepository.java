package com.mypet.mypet_be_springboot.repositories;

import com.mypet.mypet_be_springboot.models.PetModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PetRepository extends MongoRepository <PetModel, String> {
    List<PetModel> findByidOwner(String idOwner);
}
