package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Whetstone extends CommonRelic {
    @Override
    public String displayName() {
        return "磨刀石";
    }

    @Override
    public String description() {
        return "拾起时，随机 【升级】 2 张 【攻击牌】 。";
    }
}
