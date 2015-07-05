package de.fred4jupiter.spring.boot.data.jpa.repository;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import de.fred4jupiter.spring.boot.data.jpa.Application;
import de.fred4jupiter.spring.boot.data.jpa.entity.Customer;
import de.fred4jupiter.spring.boot.data.jpa.specs.CustomerSpecs;

import static de.fred4jupiter.spring.boot.data.jpa.specs.CustomerSpecs.*;
import static org.springframework.data.jpa.domain.Specifications.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	private Customer customer;
	
	@Before
	public void setup() {
		this.customer = saveCustomer();
	}
	
	@After
	public void cleanup() {
		customerRepository.delete(customer);
	}
	
	@Test
	public void findByPrimaryKey() {
		Customer foundCustomer = customerRepository.findOne(customer.getId());
		assertNotNull(foundCustomer);
		assertEquals(customer.getFirstname(), foundCustomer.getFirstname());
	}

	private Customer saveCustomer() {
		Customer customer = new Customer();
		customer.setFirstname("Fred");
		customer.setLastname("Feuerstein");
		Customer savedCustomer = customerRepository.save(customer);
		assertNotNull(savedCustomer);
		return savedCustomer;
	}

	@Test
	public void findByFirstname() {
		List<Customer> customers = customerRepository.findByFirstname(customer.getFirstname());
		assertNotNull(customers);
		assertThat(customers, hasItem(Matchers.<Customer>hasProperty("firstname", equalTo(customer.getFirstname()))));
	}
	
	@Test
	public void findByFirstnameQueryAnnotation() {
		List<Customer> customers = customerRepository.findCustomerByFirstname(customer.getFirstname());
		assertNotNull(customers);
		assertThat(customers, hasItem(Matchers.<Customer>hasProperty("firstname", equalTo(customer.getFirstname()))));
	}
	
	@Test
	public void findByFirstnameSpec() {
		List<Customer> customers = customerRepository.findAll(CustomerSpecs.hasFirstnameLike(customer.getFirstname()));
		assertNotNull(customers);
		assertThat(customers, hasItem(Matchers.<Customer>hasProperty("firstname", equalTo(customer.getFirstname()))));
	}
	
	@Test
	public void findByFirstnameAndLastnameLike() {
		Specifications<Customer> spec = where(hasFirstnameLike("Fred")).and(hasLastnameLike("Feuerstein"));
		
		List<Customer> customers = customerRepository.findAll(spec);
		assertNotNull(customers);
		assertThat(customers, hasItem(Matchers.<Customer>hasProperty("firstname", equalTo(customer.getFirstname()))));
		assertThat(customers, hasItem(Matchers.<Customer>hasProperty("lastname", equalTo(customer.getLastname()))));
	}
}
