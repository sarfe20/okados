package com.example.Okados.repository;

import com.example.Okados.model.ShopUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopUserRepository extends MongoRepository<ShopUser, String> {
    ShopUser findByEmail(String email);
}
