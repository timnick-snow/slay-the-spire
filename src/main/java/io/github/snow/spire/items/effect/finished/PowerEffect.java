package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.AutoLossPower;
import io.github.snow.spire.items.power.BasePower;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
@Slf4j
public class PowerEffect extends BaseEffect<Fighter, PowerAdder> {
    public PowerEffect(List<Fighter> targets, PowerAdder roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);
        BasePower basePower = roughEffect.getPower();
        if (!ctx.isPlayerRound() && basePower instanceof AutoLossPower lossPower) {
            log.info("power effect work on enemy round.");
            lossPower.setKeep(true);
        }
        getTargets().forEach(fighter -> fighter.addPower(roughEffect, ctx));
    }
}
