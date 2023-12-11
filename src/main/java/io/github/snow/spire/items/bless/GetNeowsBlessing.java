package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.relic.NeowsBlessing;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetNeowsBlessing implements Bless {

    @Override
    public boolean run(RunContext ctx, RunSupport support) {
        support.addRelic(new NeowsBlessing());
        return true;
    }

    @Override
    public String display(RunContext ctx) {
        return "获得遗物【涅奥的悲恸】";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.NON_CARD_RELATED;
    }
}
