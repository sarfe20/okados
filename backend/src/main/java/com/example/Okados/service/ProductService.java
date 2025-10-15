package com.example.Okados.service;

import com.example.Okados.model.Product;
import com.example.Okados.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Page<Product> getProducts(int skip, int limit) {
        int page = skip / limit; // convert skip into page index
        Pageable pageable = PageRequest.of(page, limit);
        return repo.findByShopAndActive("on", "true", pageable);
    }

    public Page<Product> findByCategory(String categoryRegex, int skip, int limit) {
        int page = skip / limit;
        Pageable pageable = PageRequest.of(page, limit);
        return repo.findByShopAndActiveAndCategoryRegexIgnoreCase("on", "true", categoryRegex, pageable);
    }

    public Optional<Product> findById(String id) {
        return repo.findById(id);
    }

    public Page<Product> findByShopEmail(String email, int skip, int limit) {
        int page = skip / limit;
        Pageable pageable = PageRequest.of(page, limit);
        return repo.findByEmail(email, pageable);
    }
}
