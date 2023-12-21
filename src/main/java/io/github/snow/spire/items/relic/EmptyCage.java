package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class EmptyCage extends BossRelic {
    @Override
    public String displayName() {
        return "空鸟笼";
    }

    @Override
    public String description() {
        return "拾起时，移除牌组中的 2 张牌。";
    }
}
