package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Lantern extends CommonRelic {
    @Override
    public String name() {
        return "灯笼";
    }

    @Override
    public String description() {
        return "在每场战斗的第一回合获得一点【能量】。";
    }
}