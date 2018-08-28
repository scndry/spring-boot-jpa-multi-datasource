package io.github.scndry.poc.code;

import lombok.Getter;

public enum Gender implements Code<String> {

    MALE("M"), FEMALE("F");

    @Getter
    private final String code;

    Gender(String code) {
        this.code = code;
    }
}
