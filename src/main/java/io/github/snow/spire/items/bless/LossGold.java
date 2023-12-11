package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * 失去金币
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossGold implements Bless {

    @Override
    public boolean run(RunContext ctx, RunSupport support) {
        support.addGold(-ctx.getGold());
        return true;
    }

    @Override
    public String display(RunContext ctx) {
        return "失去所有的金币。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.DISADVANTAGE;
    }
}
