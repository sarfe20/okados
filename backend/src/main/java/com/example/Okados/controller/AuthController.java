
package com.example.Okados.controller;

import com.example.Okados.DTO.JwtResponse;
import com.example.Okados.DTO.LoginRequest;
import com.example.Okados.DTO.SignupRequest;
import com.example.Okados.model.User;
import com.example.Okados.service.UserService;
import com.example.Okados.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignupRequest req){
        if (userService.findByEmail(req.getEmail()) != null) {
            return ResponseEntity.badRequest().body(Map.of("error", "User already exists"));
        }
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        User saved = userService.register(user);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req){
        User u = userService.findByEmail(req.getEmail());
        if (u == null || !userService.checkPassword(req.getPassword(), u.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
        String token = jwtUtil.generateToken(u.getEmail(), u.getId());
        return ResponseEntity.ok(new JwtResponse(token));
    }


    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");
        User u = userService.findByEmail(email);
        if (u == null) return ResponseEntity.badRequest().body(Map.of("success", false, "message", "User not found"));
        u.setPassword(password);
        userService.register(u);
        return ResponseEntity.ok(Map.of("success", true, "message", "Password updated successfully"));
    }


    @PostMapping("/checkEmail")
    public ResponseEntity<?> checkEmail(@RequestBody Map<String,String> body){
        String email = body.get("email");
        User u = userService.findByEmail(email);
        if (u == null) return ResponseEntity.ok(Map.of("success", false, "Message", "User does not exist"));
        return ResponseEntity.ok(Map.of("success", true, "Message", "User Exist"));
    }


    @PostMapping("/emailOTP")
    public ResponseEntity<?> emailOTP(@RequestBody Map<String,String> body){
        String email = body.get("email");
        // TODO: integrate JavaMailSender
        int otp = 100000 + new Random().nextInt(900000);
        return ResponseEntity.ok(Map.of("success", true, "otp", otp, "message", "OTP sent to " + email));
    }
}
