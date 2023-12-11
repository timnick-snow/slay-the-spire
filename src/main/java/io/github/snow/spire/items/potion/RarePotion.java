package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.PotionRarity;

/**
 * @author snow
 * @since 2023/12/11
 */
public abstract class RarePotion extends BasePotion {
    public RarePotion(String id) {
        super(id);
    }

    @Override
    public PotionRarity getRarity() {
        return PotionRarity.RARE;
    }
}
