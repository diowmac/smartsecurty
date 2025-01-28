package com.hojeti.smartsecurity.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List; // Importando a classe List

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Data
@Document(collection = "users")
public class AppUser {

    @Id
    private String uuid;

    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private LocalDateTime registerDateTime;

    private List<String> allowedFederation; 

    public AppUser() {
        this.registerDateTime = LocalDateTime.now();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(LocalDateTime registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public List<String> getAllowedFederation() {
        return allowedFederation;
    }

    public void setAllowedFederation(List<String> allowedFederation) {
        this.allowedFederation = allowedFederation;
    }
}
