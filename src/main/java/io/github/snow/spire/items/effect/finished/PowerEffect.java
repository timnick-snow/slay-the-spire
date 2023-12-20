package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.AutoLossPower;
import io.github.snow.spire.items.power.BasePower;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
public class PowerEffect extends BaseEffect<Fighter> {
    private final PowerAdder adder;

    public PowerEffect(List<Fighter> targets, PowerAdder adder) {
        super(targets);
        this.adder = adder;
    }

    @Override
    public void work(FightContext ctx) {
        BasePower basePower = adder.getPower();
        if (!ctx.isPlayerRound() && basePower instanceof AutoLossPower lossPower) {
            lossPower.setKeep(true);
        }
        getTargets().forEach(fighter -> fighter.addPower(adder, ctx));
    }
}
