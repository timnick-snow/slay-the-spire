package io.github.snow.spire.items.relic;

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
}
