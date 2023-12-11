package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class NuclearBattery extends BossRelic {
    @Override
    public String name() {
        return "核能电池";
    }

    @Override
    public String description() {
        return "在每场战斗开始时， 生成 1 个 等离子 充能球。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
