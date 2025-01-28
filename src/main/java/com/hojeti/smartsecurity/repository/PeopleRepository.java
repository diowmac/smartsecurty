package com.hojeti.smartsecurity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hojeti.smartsecurity.entity.AccessPeople;
import com.hojeti.smartsecurity.entity.People;

public interface PeopleRepository extends MongoRepository<People, String> {
	List<People> findByCpf(String cpf);
	List<People> findByName(String name);
	List<People> findByRg(String rg);
}
