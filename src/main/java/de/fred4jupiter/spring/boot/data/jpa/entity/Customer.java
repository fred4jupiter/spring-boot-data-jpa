package de.fred4jupiter.spring.boot.data.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;

	private String lastname;

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Customer rhs = (Customer) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(firstname, rhs.firstname)
				.append(lastname, rhs.lastname).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(firstname).append(lastname).toHashCode();
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).toString();
	}
}
