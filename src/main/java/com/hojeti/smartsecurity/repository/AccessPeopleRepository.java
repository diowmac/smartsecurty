package com.hojeti.smartsecurity.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hojeti.smartsecurity.entity.AccessPeople;

public interface AccessPeopleRepository extends MongoRepository<com.hojeti.smartsecurity.entity.AccessPeople, String> {

	
	List<AccessPeople> findByCpf(String cpf);
	List<AccessPeople> findByName(String name);
	List<AccessPeople> findByRg(String rg);
	
}