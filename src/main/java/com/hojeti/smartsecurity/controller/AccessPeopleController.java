package com.hojeti.smartsecurity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hojeti.smartsecurity.entity.AccessPeople;
import com.hojeti.smartsecurity.service.AccessPeopleService;

@RestController
@RequestMapping("/api/v1/accesspeople")
public class AccessPeopleController {

    private final AccessPeopleService service;

    public AccessPeopleController(AccessPeopleService service) {
        this.service = service;
    }


    @GetMapping
    public List<AccessPeople> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessPeople> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping
    public AccessPeople create(@RequestBody AccessPeople accessPeople) {
        return service.save(accessPeople);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessPeople> update(@PathVariable String id, @RequestBody AccessPeople accessPeople) {
        return service.findById(id)
                .map(existing -> {
                    accessPeople.setUuid(id);
                    return ResponseEntity.ok(service.save(accessPeople));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
  
    @GetMapping("/search/cpf")
    public ResponseEntity<?> searchByCpf(@RequestParam(required = false) String cpf) {
        if (cpf == null || cpf.isBlank()) {
            return ResponseEntity.badRequest().body("O CPF não pode ser nulo ou vazio.");
        }

        List<AccessPeople> results = service.searchByCpf(cpf);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/search/nome")
    public ResponseEntity<?> searchByName(@RequestParam String nome) {
        if (nome == null || nome.isBlank()) {
            return ResponseEntity.badRequest().body("O NOME não pode ser nulo ou vazio.");
        }

        List<AccessPeople> results = service.searchByName(nome); 
        return ResponseEntity.ok(results);
    }

    @GetMapping("/search/rg")
    public ResponseEntity<?> searchByRg(@RequestParam String rg) {
        if (rg == null || rg.isBlank()) {
            return ResponseEntity.badRequest().body("O RG não pode ser nulo ou vazio.");
        }

        List<AccessPeople> results = service.searchByRg(rg); 
        return ResponseEntity.ok(results);
    }
    
}
