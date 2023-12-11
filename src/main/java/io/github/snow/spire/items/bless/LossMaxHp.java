package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * 失去最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossMaxHp implements Bless {

    @Override
    public void run(RunContext ctx, RunSupport support) {
        support.addMaxHp(-getValue(ctx));
    }

    @Override
    public String display(RunContext ctx) {
        int value = getValue(ctx);
        return "失去%d最大生命值。".formatted(value);
    }

    private int getValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD -> 8;
            case SILENT -> 6;
            case DEFECT, WATCHER -> 7;
        };
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.DISADVANTAGE;
    }
}
