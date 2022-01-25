package com.mypet.mypet_be_springboot.models;

import org.springframework.data.annotation.Id;
import java.util.List;


public class OwnerModel {
    //Atributos
    @Id
    private String idOwner;
    private String name;
    private String phone;
    private String email;

    //Constructor
    public OwnerModel(String idOwner, String name, String phone, String email){
        this.idOwner = idOwner;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    //Metodos
    public String getIdOwner(){
        return idOwner;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public void setIdOwner(String idOwner){
        this.idOwner = idOwner;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }

}





