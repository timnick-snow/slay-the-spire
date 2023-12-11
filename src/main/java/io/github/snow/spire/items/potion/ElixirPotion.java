package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class ElixirPotion extends UncommonPotion {
    public ElixirPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "万灵药水";
    }

    @Override
    public String getDescription() {
        return "消耗 任意张手牌。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
