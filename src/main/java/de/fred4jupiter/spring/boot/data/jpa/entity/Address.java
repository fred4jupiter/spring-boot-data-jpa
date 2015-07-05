package de.fred4jupiter.spring.boot.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.Assert;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "STREET")
	private String street;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	public Address(String street, String city, String country) {
		Assert.hasText(street, "Street must not be null or empty!");
		Assert.hasText(city, "City must not be null or empty!");
		Assert.hasText(country, "Country must not be null or empty!");

		this.street = street;
		this.city = city;
		this.country = country;
	}

	protected Address() {
		// for hibernate
	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		final ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.append("street", street);
		builder.append("city", city);
		builder.append("country", country);
		return builder.toString();
	}

}
