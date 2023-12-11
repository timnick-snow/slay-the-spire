package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class PotionOfCapacity extends UncommonPotion {
    public PotionOfCapacity(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "扩容药水";
    }

    @Override
    public String getDescription() {
        return "获得 2 个充能球栏位。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
