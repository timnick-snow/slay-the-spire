package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class GoldenEye extends RareRelic {
    @Override
    public String name() {
        return "黄金眼";
    }

    @Override
    public String description() {
        return "你每次 【预见】 时，额外 【预见】 2 张牌。";
    }
}
