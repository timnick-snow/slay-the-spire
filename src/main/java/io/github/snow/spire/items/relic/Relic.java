package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.RelicRarity;

/**
 * 遗物
 *
 * @author snow
 * @since 2023/12/7
 */
public interface Relic {
    /**
     * 名称
     */
    String name();

    /**
     * 介绍
     */
    String description();

    /**
     * 稀有度
     */
    RelicRarity rarity();

    /**
     * 特属于某职业
     */
    default Characters classSpecific() {
        return null;
    }
}
