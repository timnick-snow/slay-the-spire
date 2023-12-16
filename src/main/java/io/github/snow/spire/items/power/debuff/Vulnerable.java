package io.github.snow.spire.items.power.debuff;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DamageGroup;
import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.power.AutoLossPower;

/**
 * @author snow
 * @since 2023/12/14
 */
public class Vulnerable extends AutoLossPower {

    private final double percent = 0.5;

    public Vulnerable(DisplayAble host, int num) {
        super(host, num);
    }

    public Vulnerable(DisplayAble host) {
        super(host);
    }

    @Override
    public void onBeAttacked(DamageGroup damageGroup, FightContext ctx) {
        if (damageGroup.getSource() instanceof FightCard) {
            // todo 和遗物的互动
            System.out.println("【易伤】 触发");
            int base = damageGroup.getBase();
            damageGroup.setBase((int) (base * (1 + percent)));
        }
    }

    @Override
    public String name() {
        return "易伤";
    }

    @Override
    public String description() {
        return "从 攻击 受到的伤害增加 50%% .持续 %d 回合。".formatted(this.amount());
    }

    @Override
    public String id() {
        return "Vulnerable";
    }

    @Override
    public PowerType powerType() {
        return PowerType.DEBUFF;
    }
}