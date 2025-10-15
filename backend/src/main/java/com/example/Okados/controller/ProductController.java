package com.example.Okados.controller;

import com.example.Okados.model.Product;
import com.example.Okados.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(service.getProducts(skip, limit));
    }

    @GetMapping("/category")
    public ResponseEntity<Page<Product>> getByCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(service.findByCategory(category, skip, limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/shop")
    public ResponseEntity<Page<Product>> getByShopEmail(
            @RequestParam String email,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(service.findByShopEmail(email, skip, limit));
    }
}
