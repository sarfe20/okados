package com.example.Okados.model;

import java.util.List;

public class ShopDetails {
    private String shopemail;
    private List<String> products;

    public ShopDetails(){}

    public String getShopemail(){return shopemail;} public void setShopemail(String s){this.shopemail=s;}
    public List<String> getProducts(){return products;} public void setProducts(List<String> p){this.products=p;}
}
