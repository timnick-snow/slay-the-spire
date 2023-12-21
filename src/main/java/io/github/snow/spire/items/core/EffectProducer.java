package io.github.snow.spire.items.core;

import io.github.snow.spire.items.effect.RoughEffect;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
public interface EffectProducer {

    EffectProducer GAME_MECHANICS = new InnerEmptyProducer();

    List<RoughEffect<?>> getRoughEffect(Fighter fighter);
}
