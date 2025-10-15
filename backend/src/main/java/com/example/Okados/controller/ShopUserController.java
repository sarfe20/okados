
package com.example.Okados.controller;

import com.example.Okados.model.ShopUser;
import com.example.Okados.service.ShopUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/shopuser")
public class ShopUserController {
    private final ShopUserService svc;
    public ShopUserController(ShopUserService svc){ this.svc = svc; }


    @PostMapping("/getUser")
    public ResponseEntity<?> byEmail(@RequestBody Map<String,String> body){
        String email = body.get("email");
        ShopUser shopUser = svc.findByEmail(email);
        return ResponseEntity.ok(Map.of("success", true, "message", "ShopUser find Successfully", "shopUser", shopUser));
    }
}
