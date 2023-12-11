package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetPotion implements Bless {
    @Override
    public boolean run(RunContext ctx, RunSupport support) {
        support.rewardPotion(3);
        return false;
    }

    @Override
    public String display(RunContext ctx) {
        return "获得3个随机药水。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.NON_CARD_RELATED;
    }
}
