package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class SymbioticVirus extends UncommonRelic {
    @Override
    public String name() {
        return "共生病毒";
    }

    @Override
    public String description() {
        return "在每场战斗开始时， 生成 1 个 【黑暗】 充能球。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
