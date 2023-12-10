package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class TinyHouse extends BossRelic {
    @Override
    public String name() {
        return "小屋子";
    }

    @Override
    public String description() {
        return "拾起时，获得 1 瓶药水。获得 50 金币 。将你的最大生命值提升 5。挑选 1 张牌。随机升级 1 张牌。";
    }
}
