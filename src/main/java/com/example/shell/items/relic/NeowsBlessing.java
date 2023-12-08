package com.example.shell.items.relic;

/**
 * @author snow
 * @since 2023/12/8
 */
public class NeowsBlessing implements Relic{

    private int rest = 3;

    @Override
    public String getName() {
        return "涅奥的悲恸";
    }

    @Override
    public String getDescription() {
        return "接下来 3 场战斗中的敌人将只有 1 点生命。";
    }
}
