package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.RelicRarity;

/**
 * @author snow
 * @since 2023/12/9
 */
public abstract class RareRelic extends BaseRelic {
    @Override
    public RelicRarity rarity() {
        return RelicRarity.RARE;
    }
}
