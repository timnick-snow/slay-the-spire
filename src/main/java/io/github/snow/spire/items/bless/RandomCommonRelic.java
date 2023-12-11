package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.enums.RelicRarity;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RandomCommonRelic extends RandomRelic {

    @Override
    public RelicRarity rarity() {
        return RelicRarity.COMMON;
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.NON_CARD_RELATED;
    }
}
