package io.github.snow.spire.items.core;

import io.github.snow.spire.items.effect.Effect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author snow
 * @since 2023/12/18
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SourceChain {
    private Effect<?> effect;
    private EffectProducer producer;
    private Fighter fighter;

    public SourceChain copy() {
        return new SourceChain(effect, producer, fighter);
    }
}
