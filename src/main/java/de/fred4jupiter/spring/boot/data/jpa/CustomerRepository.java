package de.fred4jupiter.spring.boot.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByName(String name);

	

}
