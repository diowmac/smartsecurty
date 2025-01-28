package com.hojeti.smartsecurity.controller;

import com.hojeti.smartsecurity.entity.AppUser;
import com.hojeti.smartsecurity.service.JwtService;
import com.hojeti.smartsecurity.service.UserService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")  
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, JwtService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")  
    public ResponseEntity<?> register(@Valid @RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        AppUser savedUser = userService.save(user);
        return ResponseEntity.status(201).body(Map.of("message", "User registered successfully", "user", savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        Optional<AppUser> optionalUser = userService.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        }

        // Verificando se a senha bate
        AppUser foundUser = optionalUser.get();
        boolean passwordMatches = passwordEncoder.matches(user.getPassword(), foundUser.getPassword());

        // Adicione um log para verificar a comparação
        System.out.println("Password matches: " + passwordMatches);

        if (!passwordMatches) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        }

        // Senha está correta, agora gera o token
        User userDetails = new User(foundUser.getUsername(), foundUser.getPassword(), new ArrayList<>());
        String token = jwtService.generateToken(userDetails);

        // Verificando se o token foi gerado corretamente
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(500).body(Map.of("error", "Failed to generate token"));
        }

        // Se o token for gerado corretamente, retornamos ele
        return ResponseEntity.ok(Map.of("token", token));
    }


}
