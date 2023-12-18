package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.finished.PowerEffect;
import io.github.snow.spire.items.power.BasePower;
import io.github.snow.spire.items.power.Power;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/15
 */
@Getter
@Setter
public class PowerAdder extends BaseRoughEffect<Fighter> {
    private final BasePower power;
    private SourceChain source;

    public PowerAdder(EffectTarget effectTarget, BasePower power) {
        super(effectTarget);
        this.power = power;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PowerEffect process(List<? extends DisplayAble> targets) {
        targets.forEach(power::setHost);
        PowerEffect effect = new PowerEffect((List<Fighter>) targets, this);
        source.setEffect(effect);
        return effect;
    }
}
