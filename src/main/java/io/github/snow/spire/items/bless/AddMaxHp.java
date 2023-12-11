package io.github.snow.spire.items.bless;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public abstract class AddMaxHp implements Bless {

    protected abstract int getAddValue(RunContext ctx);

    @Override
    public void run(RunContext ctx, RunSupport support) {
        support.addMaxHp(getAddValue(ctx));
    }

    @Override
    public String display(RunContext ctx) {
        int value = getAddValue(ctx);
        return "最大生命值+%d。".formatted(value);
    }
}
