package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Enchiridion extends EventRelic {
    @Override
    public String name() {
        return "英雄宝典";
    }

    @Override
    public String description() {
        return "每场战斗开始时增加一张随机 【能力牌】 到你的手牌，这张牌在第一回合的耗能变为 0 。";
    }
}
