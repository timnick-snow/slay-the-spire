package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class OrnamentalFan extends UncommonRelic {
    @Override
    public String name() {
        return "精致折扇";
    }

    @Override
    public String description() {
        return "你每在同一回合内打出 3 张 【攻击牌】 ，就获得 4 点 【格挡】 。";
    }
}
