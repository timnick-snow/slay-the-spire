package io.github.snow.spire.items.effect;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.power.Power;
import io.github.snow.spire.items.relic.Relic;
import io.github.snow.spire.tool.Output;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
public abstract class BaseEffect<T extends DisplayAble, S extends BaseRoughEffect<T>> implements Effect<T> {
    private final List<T> targets;
    protected final S roughEffect;

    public BaseEffect(List<T> targets, S roughEffect) {
        this.targets = targets;
        this.roughEffect = roughEffect;
        roughEffect.getSource().setEffect(this);
    }

    @Override
    public List<T> getTargets() {
        return targets;
    }

    @Override
    public void work(FightContext ctx) {
        EffectProducer producer = roughEffect.getSource().getProducer();
        if (producer instanceof Relic || producer instanceof Power) {
            DisplayAble displayAble = (DisplayAble) producer;
            Output.printf(STR."【\{displayAble.displayName()}】触发。\n");
        }
    }
}
