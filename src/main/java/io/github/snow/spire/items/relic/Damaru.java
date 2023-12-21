package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Damaru extends CommonRelic {
    @Override
    public String displayName() {
        return "手摇鼓";
    }

    @Override
    public String description() {
        return "在你的回合开始时，获得 1 层 【真言】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
