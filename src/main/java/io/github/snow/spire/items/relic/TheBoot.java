package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class TheBoot extends CommonRelic {
    @Override
    public String displayName() {
        return "发条靴";
    }

    @Override
    public String description() {
        return "每当你造成小于等于 5点 未被格挡的 【攻击】 伤害时，将伤害提升为 5。";
    }
}
