package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.PotionRarity;

/**
 * @author snow
 * @since 2023/12/11
 */
public abstract class CommonPotion extends BasePotion {
    public CommonPotion(String id) {
        super(id);
    }

    @Override
    public PotionRarity getRarity() {
        return PotionRarity.COMMON;
    }
}
