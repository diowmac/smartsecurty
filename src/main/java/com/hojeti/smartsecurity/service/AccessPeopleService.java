package com.hojeti.smartsecurity.service;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hojeti.smartsecurity.entity.AccessPeople;
import com.hojeti.smartsecurity.repository.AccessPeopleRepository;
import com.jayway.jsonpath.Criteria;

@Service
public class AccessPeopleService {
    private final AccessPeopleRepository repository;

    public AccessPeopleService(AccessPeopleRepository repository) {
        this.repository = repository;
    }

    public List<AccessPeople> findAll() {
        return repository.findAll();
    }

    public Optional<AccessPeople> findById(String uuid) {
        return repository.findById(uuid);
    }

    public AccessPeople save(AccessPeople accessPeople) {
        return repository.save(accessPeople);
    }

    public void deleteById(String uuid) {
        repository.deleteById(uuid);
    }
    
    public List<AccessPeople> searchByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
    
    public List<AccessPeople> searchByName(String nome) {
        return repository.findByName(nome);
    }
    
    public List<AccessPeople> searchByRg(String rg) {
        return repository.findByRg(rg);
    }
}
