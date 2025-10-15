package com.example.Okados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "shopusers")
public class ShopUser {
    @Id
    private String id;
    private String username;
    private String shop; // on/off
    private List<Image> image;
    private String email;
    private String shopType;
    private Long phoneNumber;
    private String password;
    private String address;
    private String landmark;
    private String pincode;
    private String city;
    private String state;
    private String country;

    public ShopUser(){}


    public String getId(){return id;} public void setId(String id){this.id=id;}

}
