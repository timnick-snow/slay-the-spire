package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class OrangePellets extends ShopRelic {
    @Override
    public String displayName() {
        return "橙色药丸";
    }

    @Override
    public String description() {
        return "你每在同一回合内打出 【能力牌】 、【攻击牌】 和 【技能牌】 各一张，移除你身上的所有负面效果。";
    }
}
