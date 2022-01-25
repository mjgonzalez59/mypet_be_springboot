package com.mypet.mypet_be_springboot.exceptions;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(String message){
        super(message);
    }
}
