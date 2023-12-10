package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class VelvetChoker extends BossRelic {
    @Override
    public String name() {
        return "天鹅绒颈圈";
    }

    @Override
    public String description() {
        return "在每回合开始时获得1点 【能量】 。你每回合不能打出超过 6 张牌。";
    }
}
