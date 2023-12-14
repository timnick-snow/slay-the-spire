package io.github.snow.spire.items.effect.debuff;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.fight.DamageGroup;
import io.github.snow.spire.enums.EffectType;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.effect.AutoLossEffect;

/**
 * @author snow
 * @since 2023/12/14
 */
public class Vulnerable extends AutoLossEffect {

    private final double percent = 0.5;

    public Vulnerable(DisplayAble host, int num) {
        super(host, num);
    }

    public Vulnerable(DisplayAble host) {
        super(host);
    }

    @Override
    public void onBeAttacked(DamageGroup damageGroup, FightContext ctx) {
        // todo 和遗物的互动
        System.out.println("【易伤】 触发");
        int base = damageGroup.getBase();
        damageGroup.setBase((int) (base * (1 + percent)));
    }

    @Override
    public String name() {
        return "易伤";
    }

    @Override
    public String description() {
        return "从 攻击 受到的伤害增加 50%% .持续 %d 回合。".formatted(this.getNum());
    }

    @Override
    public String id() {
        return "Vulnerable";
    }

    @Override
    public EffectType effectType() {
        return EffectType.DEBUFF;
    }
}
