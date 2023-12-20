package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.tool.Output;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Calipers extends RareRelic {
    private static final int LOSE_VALUE = 15;

    @Override
    public String name() {
        return "外卡钳";
    }

    @Override
    public String description() {
        return "在你的回合开始时，不再失去所有 【格挡】 ，而是失去 15 点 【格挡】 。";
    }

    @Override
    public void onBlockAutoLose(ValueWrapper loseValue, FightContext ctx) {
        int value = loseValue.getValue();
        if (value > LOSE_VALUE) {
            Output.println(STR."【\{name()}】 触发");
            loseValue.setValue(LOSE_VALUE);
        }
    }
}
