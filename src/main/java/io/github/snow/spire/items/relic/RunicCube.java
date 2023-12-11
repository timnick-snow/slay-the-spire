package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RunicCube extends BossRelic {
    @Override
    public String name() {
        return "符文立方体";
    }

    @Override
    public String description() {
        return "每当你失去生命时，抽 1 张牌。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
