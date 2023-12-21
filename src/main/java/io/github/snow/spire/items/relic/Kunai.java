package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Kunai extends UncommonRelic {
    @Override
    public String displayName() {
        return "苦无";
    }

    @Override
    public String description() {
        return "你每在同一回合内打出 3 张 攻击牌 ，获得 1点 【敏捷】 。";
    }
}
