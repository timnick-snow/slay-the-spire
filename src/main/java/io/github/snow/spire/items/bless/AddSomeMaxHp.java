package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class AddSomeMaxHp extends AddMaxHp {

    @Override
    protected int getAddValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD -> 8;
            case SILENT -> 6;
            case DEFECT, WATCHER -> 7;
        };
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.NON_CARD_RELATED;
    }
}
