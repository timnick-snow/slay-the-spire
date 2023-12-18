package io.github.snow.spire.items.effect;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.SourceChain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/18
 */
@RequiredArgsConstructor
@Getter
public abstract class BaseRoughEffect<T extends DisplayAble> implements RoughEffect<T> {
    protected final EffectTarget effectTarget;
    @Setter
    protected SourceChain source;

    @Override
    public EffectTarget effectTarget() {
        return effectTarget;
    }
}
