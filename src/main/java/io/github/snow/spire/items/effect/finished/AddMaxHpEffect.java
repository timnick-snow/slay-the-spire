package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.MaxHpAdd;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class AddMaxHpEffect extends BaseEffect<Fighter, MaxHpAdd> {
    public AddMaxHpEffect(List<Fighter> targets, MaxHpAdd roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);

        getTargets().forEach(fighter -> fighter.addMaxHp(roughEffect, ctx));
    }
}
