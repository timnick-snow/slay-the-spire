package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.tool.Output;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BlackBlood extends BossRelic {
    @Override
    public String name() {
        return "黑暗之血";
    }

    @Override
    public String description() {
        return "替换 【燃烧之血】 。在战斗结束时，回复 12点生命。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }


    @Override
    public void onFightEnd(FightContext ctx) {
        Output.println(STR."【\{name()}】触发。");
        ctx.getPlayer().heal(12);
    }
}
