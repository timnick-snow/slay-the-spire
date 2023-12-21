package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MummifiedHand extends UncommonRelic {
    @Override
    public String displayName() {
        return "干瘪之手";
    }

    @Override
    public String description() {
        return "你每打出一张 【能力牌】 ，手牌中就有一张随机牌在这个回合耗能变为 0 。";
    }
}
