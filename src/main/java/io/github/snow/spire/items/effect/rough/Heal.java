package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.finished.HealEffect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/15
 */
@Getter
@Setter
public class Heal extends BaseRoughEffect<Fighter> {
    private int value;

    public Heal(int value, SourceChain source) {
        super(EffectTarget.SELF, source);
        this.value = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public HealEffect process(List<? extends DisplayAble> targets) {
        return new HealEffect((List<Fighter>) targets, this);
    }
}
