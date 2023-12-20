package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.tool.Output;

/**
 * 燃烧之血
 *
 * @author snow
 * @since 2023/12/7
 */
public class BurningBlood extends StarterRelic {
    @Override
    public String name() {
        return "燃烧之血";
    }

    @Override
    public String description() {
        return "在战斗结束时，回复 6 点生命。";
    }

    @Override
    public void onFightEnd(FightContext ctx) {
        Output.println(STR."【\{name()}】触发。");
        ctx.getPlayer().heal(6);
    }
}
