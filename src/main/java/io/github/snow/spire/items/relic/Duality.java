package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Duality extends UncommonRelic {
    @Override
    public String name() {
        return "两仪";
    }

    @Override
    public String description() {
        return "每回合中，你每次打出一张 【攻击牌】 ，获得 1 点临时 【敏捷】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
