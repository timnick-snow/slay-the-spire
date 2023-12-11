package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class CunningPotion extends UncommonPotion {
    public CunningPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "狡诈药水";
    }

    @Override
    public String getDescription() {
        return "增加 3 张 小刀+ 到你的手牌。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
