package io.github.scndry.poc.converter;

import io.github.scndry.poc.code.OrderStatus;

import javax.persistence.Converter;

@Converter(autoApply = true)
public final class OrderStatusConverter extends AbstractEnumCodeConverter<OrderStatus, Integer> {

    public OrderStatusConverter() {
        super(OrderStatus.class);
    }
}
