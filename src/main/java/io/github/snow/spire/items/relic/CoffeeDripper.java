package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class CoffeeDripper extends BossRelic {
    @Override
    public String displayName() {
        return "咖啡滤杯";
    }

    @Override
    public String description() {
        return "在每回合开始时获得1点 【能量】 。你无法再在休息处 【休息】 。";
    }
}
