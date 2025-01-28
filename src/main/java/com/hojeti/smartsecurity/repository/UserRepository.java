package com.hojeti.smartsecurity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hojeti.smartsecurity.entity.AppUser;

import java.util.Optional;

public interface UserRepository extends MongoRepository<AppUser, String> {
    Optional<AppUser> findByUsername(String username);
}
