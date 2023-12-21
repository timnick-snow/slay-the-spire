package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.AttackResult;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/17
 */
//@Getter
public class DamageEffect extends BaseEffect<Fighter, DamageGroup> {
    public DamageEffect(List<Fighter> targets, DamageGroup roughEffect) {
        super(targets, roughEffect);
    }
    @Override
    public void work(FightContext ctx) {
        super.work(ctx);
        for (Fighter fighter : getTargets()) {
            if (!fighter.isDie()) {
                AttackResult attackResult = fighter.beAttacked(roughEffect, ctx);
                if (!fighter.isDie()) {
                    fighter.onAfterBeAttacked(attackResult, ctx);
                }
            }
        }
    }
}
