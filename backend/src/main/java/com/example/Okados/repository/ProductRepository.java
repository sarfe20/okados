package com.example.Okados.repository;

import com.example.Okados.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Page<Product> findByShopAndActive(String shop, String active, Pageable pageable);
    Page<Product> findByShopAndActiveAndCategoryRegexIgnoreCase(String shop, String active, String category, Pageable pageable);
    Page<Product> findByEmail(String email, Pageable pageable);
}
