package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class HeartOfIron extends RarePotion {
    public HeartOfIron(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "铁之心";
    }

    @Override
    public String getDescription() {
        return "获得 6 层 金属化 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
