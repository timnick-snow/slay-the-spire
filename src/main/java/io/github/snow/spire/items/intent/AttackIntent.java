package io.github.snow.spire.items.intent;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.enemy.Enemy;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/19
 */
@RequiredArgsConstructor
public class AttackIntent extends BaseIntent {
    private final int base;
    private final int num;

    @Override
    public String displayName() {
        String x = num == 1 ? "" : STR."×\{num}";
        return STR."攻击(\{base}\{x})";
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setProducer(this).setFighter(fighter);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, base, num);
        return Collections.singletonList(damageGroup);
    }

    @Override
    public String description() {
        String desc = STR."这个敌人打算发动攻击，造成 \{base} 点伤害";
        String tail = num == 1 ? "。" : STR."，连续攻击 \{num} 次。";
        return desc + tail;
    }

    @Override
    public Intent simulate(Enemy enemy, FightContext ctx) {
        DamageGroup damageGroup = (DamageGroup) this.copy().getRoughEffect(enemy).getFirst();
        enemy.powers().forEach(power -> power.simulateAttack(damageGroup, ctx));
        return new AttackIntent(damageGroup.getBase(), damageGroup.getNum());
    }

    @Override
    public Intent copy() {
        return new AttackIntent(base, num);
    }
}
