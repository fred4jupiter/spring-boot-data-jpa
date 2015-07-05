package de.fred4jupiter.spring.boot.data.jpa.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import de.fred4jupiter.spring.boot.data.jpa.entity.Customer;
import de.fred4jupiter.spring.boot.data.jpa.entity.Customer_;

public class CustomerSpecs {

	public static Specification<Customer> hasFirstnameLike(final String firstname) {
		return new Specification<Customer>() {
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.get(Customer_.firstname), firstname + "%");
			}
		};
	}

	public static Specification<Customer> hasLastnameLike(final String lastname) {
		return new Specification<Customer>() {
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				return builder.like(root.get(Customer_.lastname), lastname + "%");
			}
		};
	}
}
