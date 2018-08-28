package io.github.scndry.poc.repository.cafe;

import io.github.scndry.poc.entity.cafe.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
