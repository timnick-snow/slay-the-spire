package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class TeardropLocket extends UncommonRelic {
    @Override
    public String name() {
        return "泪滴吊坠盒";
    }

    @Override
    public String description() {
        return "每场战斗开始时处于 【平静】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
