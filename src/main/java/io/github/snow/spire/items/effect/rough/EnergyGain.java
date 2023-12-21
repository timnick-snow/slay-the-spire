package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.finished.GainEnergyEffect;
import lombok.Getter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
@Getter
public class EnergyGain extends BaseRoughEffect<DisplayAble> {

    private final int value;

    public EnergyGain(SourceChain source, int value) {
        super(EffectTarget.NONE, source);
        this.value = value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Effect<DisplayAble> process(List<? extends DisplayAble> targets) {
        return new GainEnergyEffect((List<DisplayAble>) targets, this);
    }
}
