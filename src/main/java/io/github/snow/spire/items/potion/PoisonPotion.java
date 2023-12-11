package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class PoisonPotion extends CommonPotion {
    public PoisonPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "毒药水";
    }

    @Override
    public String getDescription() {
        return "给予 5 层 中毒 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
