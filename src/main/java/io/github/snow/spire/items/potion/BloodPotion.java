package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class BloodPotion extends CommonPotion {
    public BloodPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "鲜血药水";
    }

    @Override
    public String getDescription() {
        return "回复最大生命值的 20% 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
