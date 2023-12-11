package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;
import lombok.RequiredArgsConstructor;

/**
 * 复合祝福
 *
 * @author snow
 * @since 2023/12/11
 */
@RequiredArgsConstructor
public class ComplexBless implements Bless {

    private final Bless negative;
    private final Bless positive;


    @Override
    public boolean run(RunContext ctx, RunSupport support) {
        negative.run(ctx, support);
        return positive.run(ctx, support);
    }

    @Override
    public String display(RunContext ctx) {
        return negative.display(ctx) + positive.display(ctx);
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.SPECIAL;
    }
}
