package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.finished.DrawCardEffect;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
@Getter
public class CardDraw extends BaseRoughEffect<DisplayAble> {
    private final int value;

    public CardDraw(SourceChain source, int value) {
        super(EffectTarget.NONE, source);
        this.value = value;
    }

    @Override
    public Effect<DisplayAble> process(List<? extends DisplayAble> targets) {
        return new DrawCardEffect(Collections.emptyList(), this);
    }
}
