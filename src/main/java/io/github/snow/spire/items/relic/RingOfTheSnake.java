package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RingOfTheSnake extends StarterRelic {
    @Override
    public String displayName() {
        return "蛇之戒指";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，额外抽 2 张牌。";
    }
}
