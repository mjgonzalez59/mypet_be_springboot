package com.mypet.mypet_be_springboot.repositories;

import com.mypet.mypet_be_springboot.models.OwnerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRepository extends MongoRepository<OwnerModel, String>{
}


