package de.fred4jupiter.spring.boot.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fred4jupiter.spring.boot.data.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByName(String name);

}
