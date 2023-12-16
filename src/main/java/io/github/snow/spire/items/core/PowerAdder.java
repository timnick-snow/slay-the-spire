package io.github.snow.spire.items.core;

import io.github.snow.spire.items.power.Power;
import lombok.Getter;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/15
 */
@Getter
@Setter
public class PowerAdder {
    private Power power;
    private DisplayAble source;
    private Fighter target;
}
