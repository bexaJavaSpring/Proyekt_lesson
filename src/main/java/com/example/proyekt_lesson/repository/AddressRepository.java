package com.example.proyekt_lesson.repository;

import com.example.proyekt_lesson.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="addresses", path="addresses")
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
