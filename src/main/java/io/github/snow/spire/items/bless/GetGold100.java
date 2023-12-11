package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetGold100 extends GetGold {

    private static final int GOLD_ADD = 100;

    @Override
    protected int getGoldAdd() {
        return GOLD_ADD;
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.NON_CARD_RELATED;
    }
}
