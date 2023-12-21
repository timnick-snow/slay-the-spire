package io.github.snow.spire.items.intent;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.BasePower;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/19
 */
@RequiredArgsConstructor
public class DebuffStrategic extends BaseIntent {

    private final BasePower power;

    @Override
    public String displayName() {
        return "弱化";
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        PowerAdder adder = new PowerAdder(EffectTarget.SINGLE_OPPONENT, source, power);
        return Collections.singletonList(adder);
    }

    @Override
    public String description() {
        return "这个敌人打算对你使用减益效果。";
    }

    @Override
    public Intent copy() {
        return new DebuffStrategic((BasePower) power.copy());
    }
}
