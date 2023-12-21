package io.github.snow.spire.items.core;

import io.github.snow.spire.items.effect.RoughEffect;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
final class InnerEmptyProducer implements EffectProducer {
    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        return Collections.emptyList();
    }
}
