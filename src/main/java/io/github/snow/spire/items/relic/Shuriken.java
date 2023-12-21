package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Shuriken extends UncommonRelic {
    @Override
    public String displayName() {
        return "手里剑";
    }

    @Override
    public String description() {
        return "你每在同一回合内打出 3 张 【攻击牌】 ，获得 1点 【力量】 。";
    }
}
