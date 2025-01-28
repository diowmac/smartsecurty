package com.hojeti.smartsecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hojeti.smartsecurity.entity.AccessPeople;
import com.hojeti.smartsecurity.entity.People;
import com.hojeti.smartsecurity.repository.PeopleRepository;

@Service
public class PeopleService {
    private final PeopleRepository repository;

    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<People> findAll() {
        return repository.findAll();
    }

    public Optional<People> findById(String uuid) {
        return repository.findById(uuid);
    }

    public People save(People people) {
        return repository.save(people);
    }

    public void deleteById(String uuid) {
        repository.deleteById(uuid);
    }
    
    public List<People> searchByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
    
    public List<People> searchByName(String nome) {
        return repository.findByName(nome);
    }
    
    public List<People> searchByRg(String rg) {
        return repository.findByRg(rg);
    }
}