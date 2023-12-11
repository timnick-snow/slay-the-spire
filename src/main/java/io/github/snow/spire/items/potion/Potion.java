package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.PotionRarity;

import java.io.Serializable;

/**
 * @author snow
 * @since 2023/12/7
 */
public interface Potion extends Serializable {
    /**
     * 标识
     */
    String getId();

    /**
     * 名称
     */
    String getName();

    /**
     * 介绍
     */
    String getDescription();

    PotionRarity getRarity();

    /**
     * 特属于某职业
     */
    default Characters classSpecific() {
        return null;
    }

    Potion copy(String id);
}
