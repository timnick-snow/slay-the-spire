package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BustedCrown extends BossRelic {
    @Override
    public String name() {
        return "破碎金冠";
    }

    @Override
    public String description() {
        return "在每回合开始时获得1点 【能量】 。在卡牌奖励画面，可供选择的牌数减少 2 张。";
    }
}
