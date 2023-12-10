package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

public interface Card {

    CardColor color();
    CardType type();
    CardRarity rarity();
    /**
     * 标识
     */
    String id();

    /**
     * 名称
     */
    String name();

    /**
     * 介绍
     */
    String description();
}
