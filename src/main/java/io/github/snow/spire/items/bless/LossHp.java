package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * 失去生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossHp implements Bless {

    @Override
    public void run(RunContext ctx, RunSupport support) {
        support.addHp(-getValue(ctx));
    }

    @Override
    public String display(RunContext ctx) {
        int value = getValue(ctx);
        return "受到%d伤害。".formatted(value);
    }

    private int getValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD, DEFECT -> 18;
            case SILENT -> 15;
            case WATCHER -> 21;
        };
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.DISADVANTAGE;
    }
}
