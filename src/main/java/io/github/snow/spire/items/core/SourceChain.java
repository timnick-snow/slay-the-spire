package io.github.snow.spire.items.core;

import io.github.snow.spire.items.effect.Effect;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author snow
 * @since 2023/12/18
 */
@Getter
@Setter
@Accessors(chain = true)
public class SourceChain {
    private Effect<?> effect;
    private EffectProducer producer;
    private Fighter fighter;
}
