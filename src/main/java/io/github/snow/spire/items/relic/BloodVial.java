package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;

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
    public void onPlayerRoundStart(FightContext ctx) {
        trigger();
        ctx.getPlayer().heal(2);
    }
}
