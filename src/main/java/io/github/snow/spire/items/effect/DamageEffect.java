package io.github.snow.spire.items.effect;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DamageGroup;
import io.github.snow.spire.items.core.EffectTarget;

/**
 * @author snow
 * @since 2023/12/17
 */
public record DamageEffect(DamageGroup damageGroup) implements Effect {


    @Override
    public void work(EffectTarget target, FightContext ctx) {
        target.getMaster().beAttacked(damageGroup, ctx);
    }
}
