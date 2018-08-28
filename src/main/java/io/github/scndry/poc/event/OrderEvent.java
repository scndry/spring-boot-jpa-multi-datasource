package io.github.scndry.poc.event;

import io.github.scndry.poc.entity.cafe.Order;
import lombok.Data;

public abstract class OrderEvent {

    @Data
    public static final class Ordered extends OrderEvent {

        private final Order order;

        public Ordered(Order order) {
            this.order = order;
        }
    }
}
