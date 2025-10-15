package com.example.Okados.service;

import com.example.Okados.model.ShopUser;
import com.example.Okados.repository.ShopUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopUserService {
    private final ShopUserRepository repo;
    public ShopUserService(ShopUserRepository repo){ this.repo = repo; }
    public ShopUser findByEmail(String email){ return repo.findByEmail(email); }
}
