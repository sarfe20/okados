package com.example.Okados.DTO;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class OrderRequest {
    private String username;
    private String email;
    private Integer phoneNumber;
    private String landmark;
    private String address;
    private Map<String, Object> geolocation;
    private Double totalPrice;
    private Double deliveryAmount;
    private List<Map<String, Object>> cart;
    private String paymentMethod;
}