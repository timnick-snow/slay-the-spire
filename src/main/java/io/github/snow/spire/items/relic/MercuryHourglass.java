package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MercuryHourglass extends UncommonRelic {
    @Override
    public String displayName() {
        return "水银沙漏";
    }

    @Override
    public String description() {
        return "在你的回合开始时，对所有敌人造成 3 点伤害。";
    }
}
