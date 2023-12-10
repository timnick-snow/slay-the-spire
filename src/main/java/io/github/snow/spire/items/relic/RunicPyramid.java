package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RunicPyramid extends BossRelic {
    @Override
    public String name() {
        return "符文金字塔";
    }

    @Override
    public String description() {
        return "你在回合结束时不再自动丢弃手牌。";
    }
}
