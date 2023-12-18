package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import lombok.Getter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/17
 */
@Getter
public class DamageEffect extends BaseEffect<Fighter> {
    private final DamageGroup damageGroup;


    public DamageEffect(List<Fighter> targets, DamageGroup damageGroup) {
        super(targets);
        this.damageGroup = damageGroup;
    }

    @Override
    public void work(FightContext ctx) {
        getTargets().forEach(fighter -> fighter.beAttacked(damageGroup, ctx));
    }
}
