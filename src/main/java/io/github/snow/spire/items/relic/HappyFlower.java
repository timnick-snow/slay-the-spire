package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class HappyFlower extends CommonRelic {
    @Override
    public String displayName() {
        return "开心小花";
    }

    @Override
    public String description() {
        return "每 3 个回合，获得一点【能量】。";
    }
}
