package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BagOfPreparation extends CommonRelic {
    @Override
    public String name() {
        return "准备背包";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，额外抽 2 张牌。";
    }
}
