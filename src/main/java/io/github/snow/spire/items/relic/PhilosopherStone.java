package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class PhilosopherStone extends BossRelic {
    @Override
    public String name() {
        return "贤者之石";
    }

    @Override
    public String description() {
        return "在每回合开始时获得一点能量。所有敌人初始获得 1点 【力量】。";
    }
}
