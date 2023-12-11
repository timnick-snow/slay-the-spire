package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class VioletLotus extends BossRelic {
    @Override
    public String name() {
        return "紫色莲花";
    }

    @Override
    public String description() {
        return "每次你离开 【平静】 时，获得一点额外 【能量】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
