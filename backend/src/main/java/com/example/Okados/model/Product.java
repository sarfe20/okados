package com.example.Okados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String title;
    private String shop; // "on"/"off"
    private String active; // "true"/"false"
    private String shopname;
    private String email;
    private String description;
    private List<Image> image;
    private String category;
    private String foodCategory;
    private String shopType;
    private Double price;
    private Object availability;

    public Product() {}


    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getTitle(){return title;} public void setTitle(String t){this.title=t;}
    public String getShop(){return shop;} public void setShop(String s){this.shop=s;}
    public String getActive(){return active;} public void setActive(String a){this.active=a;}
    public String getShopname(){return shopname;} public void setShopname(String n){this.shopname=n;}
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
    public List<Image> getImage(){return image;} public void setImage(List<Image> i){this.image=i;}
    public String getCategory(){return category;} public void setCategory(String c){this.category=c;}
    public String getFoodCategory(){return foodCategory;} public void setFoodCategory(String f){this.foodCategory=f;}
    public String getShopType(){return shopType;} public void setShopType(String s){this.shopType=s;}
    public Double getPrice(){return price;} public void setPrice(Double p){this.price=p;}
    public Object getAvailability(){return availability;} public void setAvailability(Object a){this.availability=a;}
}
