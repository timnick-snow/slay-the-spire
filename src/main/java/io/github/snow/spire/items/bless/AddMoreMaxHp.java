package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class AddMoreMaxHp extends AddMaxHp {

    @Override
    protected int getAddValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD -> 16;
            case SILENT -> 12;
            case DEFECT, WATCHER -> 14;
        };
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.BETTER_REWARD;
    }
}
