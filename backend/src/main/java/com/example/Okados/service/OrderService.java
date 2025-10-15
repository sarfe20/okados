package com.example.Okados.service;

import com.example.Okados.model.Order;
import com.example.Okados.model.Product;
import com.example.Okados.repository.OrderRepository;
import com.example.Okados.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public Optional<Order> findById(String id) {
        return orderRepo.findById(id);
    }

    public List<String> gatherFirstImagesForOrder(Order order) {
        List<String> imageUrls = new ArrayList<>();
        if (order == null || order.getProducts() == null) return imageUrls;

        order.getProducts().forEach(item ->
                productRepo.findById(item.getId()).ifPresent(product -> {
                    if (product.getImage() != null && !product.getImage().isEmpty()) {
                        imageUrls.add(product.getImage().get(0).getSecureUrl());
                    }
                })
        );
        return imageUrls;
    }

    public List<Order> findByEmail(String email) {
        return orderRepo.findByEmail(email);
    }

    public Order save(Order order) {
        return orderRepo.save(order);
    }
}
