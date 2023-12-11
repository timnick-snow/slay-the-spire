package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class SelfFormingClay extends UncommonRelic {
    @Override
    public String name() {
        return "自成型黏土";
    }

    @Override
    public String description() {
        return "每当你在战斗中失去生命，就在下回合获得 3 点 【格挡】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
