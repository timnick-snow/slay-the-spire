package io.github.snow.spire.items.effect;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
public interface RoughEffect<T extends DisplayAble> {
    Effect<T> process(List<? extends DisplayAble> targets);

    EffectTarget effectTarget();
}
