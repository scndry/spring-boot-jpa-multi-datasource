package io.github.scndry.poc.repository.cafe;

import io.github.scndry.poc.entity.cafe.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
