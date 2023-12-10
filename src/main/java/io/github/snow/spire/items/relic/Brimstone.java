package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Brimstone extends ShopRelic {
    @Override
    public String name() {
        return "硫磺";
    }

    @Override
    public String description() {
        return "在你的每个回合开始时，你获得 2 点 【力量】 ，所有敌人也获得 1 【力量】。";
    }
}
