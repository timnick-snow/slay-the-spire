package com.example.shell.items.relic;

/**
 * @author snow
 * @since 2023/12/8
 */
public class BagOfMarbles implements Relic {
    @Override
    public String getName() {
        return "弹珠袋";
    }

    @Override
    public String getDescription() {
        return "在每场战斗开始时，给予所有敌人 1 层【易伤】";
    }
}
