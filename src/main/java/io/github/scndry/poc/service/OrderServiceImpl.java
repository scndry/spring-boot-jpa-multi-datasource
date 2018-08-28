package io.github.scndry.poc.service;

import io.github.scndry.poc.repository.cafe.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(ApplicationEventPublisher applicationEventPublisher, OrderRepository orderRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.orderRepository = orderRepository;
    }
}
