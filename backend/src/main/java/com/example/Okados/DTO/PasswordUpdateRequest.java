package com.example.Okados.DTO;

import lombok.Data;

@Data
public class PasswordUpdateRequest {
    private String email;
    private String password;
}