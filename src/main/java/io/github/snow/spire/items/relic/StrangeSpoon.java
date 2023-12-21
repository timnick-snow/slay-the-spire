package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class StrangeSpoon extends ShopRelic {
    @Override
    public String displayName() {
        return "奇怪的勺子";
    }

    @Override
    public String description() {
        return "应该 【消耗】 的牌在被打出时会有 50% 几率只被丢弃。";
    }
}
