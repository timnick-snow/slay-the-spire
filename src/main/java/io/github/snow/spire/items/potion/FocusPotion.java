package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class FocusPotion extends CommonPotion {
    public FocusPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "集中药水";
    }

    @Override
    public String getDescription() {
        return "获得 2 点 集中 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
