package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Sozu extends BossRelic {
    @Override
    public String name() {
        return "添水";
    }

    @Override
    public String description() {
        return "在每回合开始时获得一点 【能量】 。你无法再获得药水。";
    }
}
