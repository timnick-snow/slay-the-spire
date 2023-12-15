package io.github.snow.spire.items.core;

import io.github.snow.spire.items.effect.Effect;
import lombok.Getter;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/15
 */
@Getter
@Setter
public class EffectAdder {
    private Effect effect;
    private DisplayAble source;
    private Fighter target;
}
