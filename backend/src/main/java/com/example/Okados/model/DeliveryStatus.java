package com.example.Okados.model;

public class DeliveryStatus {
    private String pack = "pending";
    private String shipped = "pending";
    private String deliver = "pending";

    public DeliveryStatus(){}
    public String getPack(){return pack;} public void setPack(String p){this.pack=p;}
    public String getShipped(){return shipped;} public void setShipped(String s){this.shipped=s;}
    public String getDeliver(){return deliver;} public void setDeliver(String d){this.deliver=d;}
}
