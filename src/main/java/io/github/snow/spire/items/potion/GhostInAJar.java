package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class GhostInAJar extends RarePotion {
    public GhostInAJar(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "罐装幽灵";
    }

    @Override
    public String getDescription() {
        return "获得 1 层 无实体 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
