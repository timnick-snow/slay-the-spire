package com.example.shell.items.relic;

import com.example.shell.enums.Characters;
import com.example.shell.enums.RelicRarity;

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
     * 特属于某职业的遗物
     */
    default Characters classSpecific() {
        return null;
    }
}
