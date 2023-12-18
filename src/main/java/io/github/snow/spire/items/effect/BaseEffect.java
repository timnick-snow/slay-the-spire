package io.github.snow.spire.items.effect;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
@RequiredArgsConstructor
public abstract class BaseEffect<T extends DisplayAble> implements Effect<T> {
    private final List<T> targets;

    @Override
    public List<T> getTargets() {
        return targets;
    }
}
