package io.github.scndry.poc.code;

import lombok.Getter;

public enum OrderStatus implements Code<Integer> {

    ORDERED(1), READY(2), DELIVERED(3);

    @Getter
    private final Integer code;

    OrderStatus(int code) {
        this.code = code;
    }
}
