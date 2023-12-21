package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MagicFlower extends RareRelic {
    @Override
    public String displayName() {
        return "魔法花";
    }

    @Override
    public String description() {
        return "战斗中的回复效果提升 50% 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
