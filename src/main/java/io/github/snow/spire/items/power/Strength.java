package io.github.snow.spire.items.power;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.PowerType;
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
