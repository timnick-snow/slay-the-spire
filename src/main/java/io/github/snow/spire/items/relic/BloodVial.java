package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.tool.Output;

/**
 * @author snow
 * @since 2023/12/9
 */
public class BloodVial extends CommonRelic {
    @Override
    public String name() {
        return "小血瓶";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，回复 2 点生命。";
    }

    @Override
    public void onRoundStart(FightContext ctx) {
        Output.println(STR."【\{name()}】触发。");
        ctx.getPlayer().heal(2);
    }
}
