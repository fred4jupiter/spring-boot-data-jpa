package de.fred4jupiter.spring.boot.data.jpa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import de.fred4jupiter.spring.boot.data.jpa.entity.Customer;
import de.fred4jupiter.spring.boot.data.jpa.repository.CustomerRepository;

@Component
@Profile("demodata")
public class DemoDataPopulator {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostConstruct
	public void populateDemoData() {
		System.out.println("*** Populating demo data...");
		saveCustomer("Fred", "Feuerstein");
		saveCustomer("Wilma", "Feuerstein");
		saveCustomer("Bernd", "DasBrot");
	}
	
	private void saveCustomer(String firstname, String lastname) {
		Customer customer = new Customer();
		customer.setFirstname(firstname);
		customer.setLastname(lastname);
		customerRepository.saveAndFlush(customer);
	}
}
