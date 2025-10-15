package com.example.Okados.model;

public class PaymentInfo {
    private String method = "Pay on delivery";
    private String paymentStatus = "pending";

    public PaymentInfo(){}
    public String getMethod(){return method;} public void setMethod(String m){this.method=m;}
    public String getPaymentStatus(){return paymentStatus;} public void setPaymentStatus(String s){this.paymentStatus=s;}
}
