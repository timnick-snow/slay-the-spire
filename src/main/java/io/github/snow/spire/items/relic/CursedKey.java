package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class CursedKey extends BossRelic {
    @Override
    public String displayName() {
        return "诅咒钥匙";
    }

    @Override
    public String description() {
        return "你每次打开一个非Boss宝箱，都会获得一张 【诅咒】 。在每回合开始时获得一点【能量】。";
    }
}
