package com.example.Okados.DTO;

public class JwtResponse {
    private String token;
    private String tokenType = "Bearer";

    public JwtResponse(String token){this.token = token;}
    public String getToken(){return token;} public void setToken(String t){this.token=t;}
    public String getTokenType(){return tokenType;} public void setTokenType(String t){this.tokenType=t;}
}
