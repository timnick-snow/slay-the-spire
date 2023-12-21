package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class DeadBranch extends RareRelic {
    @Override
    public String displayName() {
        return "枯木树枝";
    }

    @Override
    public String description() {
        return "每当你 【消耗】 一张牌，增加一张随机卡牌到你的手牌。";
    }
}
