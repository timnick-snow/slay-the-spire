package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class ArtOfWar extends CommonRelic {
    @Override
    public String displayName() {
        return "孙子兵法";
    }

    @Override
    public String description() {
        return "如果你在回合中不打出任何 【攻击牌】 ，在下一回合得到一点额外 【能量】。";
    }
}
