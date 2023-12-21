package io.github.snow.spire.items.power;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.items.effect.rough.DamageGroup;

/**
 * @author snow
 * @since 2023/12/19
 */
public class Strength extends BasePower {

    public Strength(int num) {
        super(num);
    }

    @Override
    public void onAttack(DamageGroup damageGroup, FightContext ctx) {
        ValueWrapper valueWrapper = ValueWrapper.of(num);
        EffectProducer producer = damageGroup.getSource().getProducer();
        if (producer instanceof Card card) {
            card.onStrengthEffect(valueWrapper, ctx);
        }
        damageGroup.setBase(damageGroup.getBase() + valueWrapper.getValue());
    }

    @Override
    public void simulateAttack(DamageGroup damageGroup, FightContext ctx) {
        damageGroup.setBase(damageGroup.getBase() + amount());
    }

    @Override
    public String name() {
        return "力量";
    }

    @Override
    public String description() {
        return "攻击伤害提升 %d 点。".formatted(amount());
    }

    @Override
    public String id() {
        return "Strength";
    }

    @Override
    public PowerType powerType() {
        return amount() >= 0 ? PowerType.BUFF : PowerType.DEBUFF;
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
