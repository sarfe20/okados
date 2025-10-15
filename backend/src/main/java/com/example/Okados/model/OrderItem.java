package com.example.Okados.model;

public class OrderItem {
    private String id; // product id
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private String foodCategory;

    public OrderItem(){}


    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
    public Integer getQuantity(){return quantity;} public void setQuantity(Integer q){this.quantity=q;}
    public Double getPrice(){return price;} public void setPrice(Double p){this.price=p;}
    public String getFoodCategory(){return foodCategory;} public void setFoodCategory(String f){this.foodCategory=f;}
}
