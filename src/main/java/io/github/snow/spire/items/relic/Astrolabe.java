package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Astrolabe extends BossRelic {
    @Override
    public String name() {
        return "星盘";
    }

    @Override
    public String description() {
        return "拾起时，选择 3 张牌进行 【变化】 ，然后将这些牌 【升级】 。";
    }
}
