package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class WarpedTongs extends EventRelic {
    @Override
    public String name() {
        return "弯曲铁钳";
    }

    @Override
    public String description() {
        return "在你的每个回合开始时，随机 【升级】 一张你的手牌。";
    }
}
