package io.github.scndry.poc.converter;

import io.github.scndry.poc.code.Gender;

import javax.persistence.Converter;

@Converter(autoApply = true)
public final class GenderConverter extends AbstractEnumCodeConverter<Gender, String> {

    public GenderConverter() {
        super(Gender.class);
    }
}
