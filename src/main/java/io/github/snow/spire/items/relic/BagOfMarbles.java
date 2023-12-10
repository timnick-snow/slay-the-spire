package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023/12/8
 */
public class BagOfMarbles extends CommonRelic {
    @Override
    public String name() {
        return "弹珠袋";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，给予所有敌人 1 层【易伤】";
    }
}
