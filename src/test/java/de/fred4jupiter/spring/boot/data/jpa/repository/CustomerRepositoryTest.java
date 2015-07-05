package de.fred4jupiter.spring.boot.data.jpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.fred4jupiter.spring.boot.data.jpa.Application;
import de.fred4jupiter.spring.boot.data.jpa.entity.Customer;
import de.fred4jupiter.spring.boot.data.jpa.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
		Customer savedCustomer = saveCustomer();

		Customer foundCustomer = customerRepository.findOne(savedCustomer.getId());
		assertNotNull(foundCustomer);
		assertEquals(savedCustomer.getName(), foundCustomer.getName());
	}

	private Customer saveCustomer() {
		Customer customer = new Customer();
		customer.setName("sdfs");
		Customer savedCustomer = customerRepository.save(customer);
		assertNotNull(savedCustomer);
		return savedCustomer;
	}

	@Test
	public void findByName() {
		Customer savedCustomer = saveCustomer();

		Customer foundCustomer = customerRepository.findByName(savedCustomer.getName());
		assertNotNull(foundCustomer);
		assertEquals(savedCustomer.getName(), foundCustomer.getName());
	}
}
