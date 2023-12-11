package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class EssenceOfDarkness extends RarePotion {
    public EssenceOfDarkness(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "暗之精华";
    }

    @Override
    public String getDescription() {
        return "每个充能球栏位 生成 1 个 黑暗 充能球。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
