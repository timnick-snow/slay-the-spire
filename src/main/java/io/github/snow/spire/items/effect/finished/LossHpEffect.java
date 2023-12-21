package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.HpLoss;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class LossHpEffect extends BaseEffect<Fighter, HpLoss> {
    public LossHpEffect(List<Fighter> targets, HpLoss roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);

        getTargets().forEach(fighter -> fighter.lossHp(roughEffect, ctx));
    }
}
