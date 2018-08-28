package io.github.scndry.poc.service;

import io.github.scndry.poc.entity.cafelog.OrderLog;
import io.github.scndry.poc.repository.cafelog.OrderLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderLogServiceImpl implements OrderLogService {

    private final OrderLogRepository orderLogRepository;

    public OrderLogServiceImpl(OrderLogRepository orderLogRepository) {
        this.orderLogRepository = orderLogRepository;
    }

    @Override
    public OrderLog createLog(OrderLog orderLog) {
        return orderLogRepository.save(orderLog);
    }
}
