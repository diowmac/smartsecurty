package com.hojeti.smartsecurity.service;


import com.hojeti.smartsecurity.entity.AccessPeople;
import com.hojeti.smartsecurity.entity.AppUser;
import com.hojeti.smartsecurity.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_USER")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
    
    public AppUser save(AppUser user) {
        
        return userRepository.save(user);
    }
    
    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    
}
