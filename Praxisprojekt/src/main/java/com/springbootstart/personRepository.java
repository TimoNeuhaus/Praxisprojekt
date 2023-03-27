package com.springbootstart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepository
        extends JpaRepository<Person, Integer> {
}
