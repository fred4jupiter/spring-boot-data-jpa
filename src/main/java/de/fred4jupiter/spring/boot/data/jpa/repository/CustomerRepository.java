package de.fred4jupiter.spring.boot.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.fred4jupiter.spring.boot.data.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByFirstname(String firstname);
	
	@Query("Select c from Customer c where c.firstname = :firstname")
	List<Customer> findCustomerByFirstname(@Param("firstname") String firstname);

}
