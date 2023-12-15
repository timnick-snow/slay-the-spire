package io.github.snow.spire.items.core;

import lombok.Getter;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/14
 */
@Getter
@Setter
public class ValueWrapper {
    private int value;

    public ValueWrapper(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ValueWrapper of(int value) {
        return new ValueWrapper(value);
    }
}
