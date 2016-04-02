package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person,Long> {
    @RestResource(path = "names")
    List<Person> findByName(String name);
}
