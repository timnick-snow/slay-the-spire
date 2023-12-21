package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BottledFlame extends UncommonRelic {
    @Override
    public String displayName() {
        return "瓶装火焰";
    }

    @Override
    public String description() {
        return "拾起时，选择一张 【攻击牌】 。在每场战斗开始时，这张牌会出现在手牌中。";
    }
}
