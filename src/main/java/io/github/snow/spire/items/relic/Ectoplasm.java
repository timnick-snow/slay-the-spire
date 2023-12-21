package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Ectoplasm extends BossRelic {
    @Override
    public String displayName() {
        return "灵体外质";
    }

    @Override
    public String description() {
        return "在每回合开始时获得一点 【能量】 。你不能再获得任何 【金币】 。";
    }
}
