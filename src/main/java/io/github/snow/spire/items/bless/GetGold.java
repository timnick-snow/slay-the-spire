package io.github.snow.spire.items.bless;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public abstract class GetGold implements Bless {

    protected abstract int getGoldAdd();

    @Override
    public void run(RunContext ctx, RunSupport support) {
        support.addGold(getGoldAdd());
    }

    @Override
    public String display(RunContext ctx) {
        return "获得%d金币。".formatted(getGoldAdd());
    }
}
