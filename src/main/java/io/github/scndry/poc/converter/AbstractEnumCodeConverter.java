package io.github.scndry.poc.converter;

import io.github.scndry.poc.code.Code;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

public abstract class AbstractEnumCodeConverter<E extends Enum<E> & Code<T>, T>
    implements AttributeConverter<E, T> {

    private final Class<E> type;

    public AbstractEnumCodeConverter(Class<E> type) {
        this.type = type;
    }

    @Override
    public T convertToDatabaseColumn(E attribute) {
        return attribute.getCode();
    }

    @Override
    public E convertToEntityAttribute(T dbData) {
        if (dbData == null) return null;
        return EnumSet.allOf(type).stream()
            .filter(e -> e.getCode().equals(dbData))
            .findFirst()
            .orElseThrow(IllegalAccessError::new);
    }
}
