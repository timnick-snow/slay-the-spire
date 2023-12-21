package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.Heal;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
public class HealEffect extends BaseEffect<Fighter, Heal> {
    public HealEffect(List<Fighter> targets, Heal roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);
        getTargets().forEach(fighter -> fighter.heal(roughEffect, ctx));
    }
}
