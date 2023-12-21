package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.finished.LossHpEffect;
import lombok.Getter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
@Getter
public class HpLoss extends BaseRoughEffect<Fighter> {
    private final int value;

    public HpLoss(EffectTarget effectTarget, SourceChain source, int value) {
        super(effectTarget, source);
        this.value = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Effect<Fighter> process(List<? extends DisplayAble> targets) {
        return new LossHpEffect((List<Fighter>) targets, this);
    }
}
