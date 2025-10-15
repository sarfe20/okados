package com.example.Okados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String username;
    private String email;
    private Long phoneNumber;
    private String landmark;
    private String orderId; // frontend order id
    private List<com.example.Okados.model.ShopDetails> shopDetails;
    private com.example.Okados.model.PaymentInfo paymentInfo;
    private List<com.example.Okados.model.OrderItem> products;
    private String address;
    private Geolocation geolocation;
    private Double amount;
    private Double deliveryamount;
    private DeliveryStatus deliverystatus;

    public Order(){}


    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getUsername(){return username;} public void setUsername(String u){this.username=u;}
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public Long getPhoneNumber(){return phoneNumber;} public void setPhoneNumber(Long n){this.phoneNumber=n;}
    public String getLandmark(){return landmark;} public void setLandmark(String l){this.landmark=l;}
    public String getOrderId(){return orderId;} public void setOrderId(String o){this.orderId=o;}
    public List<com.example.Okados.model.ShopDetails> getShopDetails(){return shopDetails;} public void setShopDetails(List<ShopDetails> s){this.shopDetails=s;}
    public com.example.Okados.model.PaymentInfo getPaymentInfo(){return paymentInfo;} public void setPaymentInfo(PaymentInfo p){this.paymentInfo=p;}
    public List<com.example.Okados.model.OrderItem> getProducts(){return products;} public void setProducts(List<OrderItem> p){this.products=p;}
    public String getAddress(){return address;} public void setAddress(String a){this.address=a;}
    public Geolocation getGeolocation(){return geolocation;} public void setGeolocation(Geolocation g){this.geolocation=g;}
    public Double getAmount(){return amount;} public void setAmount(Double a){this.amount=a;}
    public Double getDeliveryamount(){return deliveryamount;} public void setDeliveryamount(Double d){this.deliveryamount=d;}
    public DeliveryStatus getDeliverystatus(){return deliverystatus;} public void setDeliverystatus(DeliveryStatus d){this.deliverystatus=d;}
}
