package io.github.snow.spire.items.power.debuff;

import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.power.AutoLossPower;

/**
 * @author snow
 * @since 2023/12/14
 */
public class Weak extends AutoLossPower {

    private final double percent = 0.25;

    public Weak(int num) {
        this.num = num;
    }

    @Override
    public String name() {
        return "虚弱";
    }

    @Override
    public String description() {
        return STR."攻击 造成的伤害减少 25% 。持续 \{amount()} 回合。";
    }

    @Override
    public String id() {
        return "Weak";
    }

    @Override
    public PowerType powerType() {
        return PowerType.DEBUFF;
    }
}
