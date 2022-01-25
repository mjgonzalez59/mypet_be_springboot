package com.mypet.mypet_be_springboot.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class PetModel {
    //Atributos

    @Id
    private String id;
    private String name;
    private String type;
    private String breed;
    private String gender;
    private double weight;
    private double size;
    private Date birthDate;
    private String idOwner;

    //Constructor
    public PetModel(String id, String name, String type, String breed, String gender, double weight, double size, Date birthDate, String idOwner){
        this.id = id;
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.gender = gender;
        this.weight = weight;
        this.size = size;
        this.birthDate = birthDate;
        this.idOwner = idOwner;
    }

    //Metodos
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public  String getBreed(){
        return breed;
    }

    public String getGender(){
        return gender;
    }

    public double getWeight(){
        return weight;
    }

    public double getSize(){
        return size;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public String getIdOwner(){
        return idOwner;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setSize(double size){
        this.size = size;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public void setIdOwner(String idOwner){
        this.idOwner = idOwner;
    }
}
