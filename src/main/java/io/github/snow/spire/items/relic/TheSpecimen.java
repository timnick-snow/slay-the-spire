package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class TheSpecimen extends RareRelic {
    @Override
    public String name() {
        return "生物样本";
    }

    @Override
    public String description() {
        return "每当有敌人死去时，将其身上的 【中毒】 层数移到一名随机敌人身上。";
    }
}
