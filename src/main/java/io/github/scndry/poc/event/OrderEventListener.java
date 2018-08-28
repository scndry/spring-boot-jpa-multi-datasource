package io.github.scndry.poc.event;

import io.github.scndry.poc.entity.cafelog.OrderLog;
import io.github.scndry.poc.service.OrderLogService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    private final OrderLogService orderLogService;

    public OrderEventListener(OrderLogService orderLogService) {
        this.orderLogService = orderLogService;
    }

    @Async
    @EventListener(OrderEvent.Ordered.class)
    public void handlerOrdered(OrderEvent.Ordered event) {
        final OrderLog orderLog = new OrderLog();
        orderLogService.createLog(orderLog);
    }
}
