package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class HolyWater extends BossRelic {
    @Override
    public String name() {
        return "圣水";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，将 3 张 【奇迹】 放入你的手牌。";
    }
}
