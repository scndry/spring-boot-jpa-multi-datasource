package io.github.scndry.poc.repository.cafelog;

import io.github.scndry.poc.entity.cafelog.OrderLog;
import org.springframework.data.repository.CrudRepository;

public interface OrderLogRepository extends CrudRepository<OrderLog, Long> {
}
