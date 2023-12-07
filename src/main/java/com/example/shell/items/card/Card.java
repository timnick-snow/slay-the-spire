package com.example.shell.items.card;

import com.example.shell.enums.CardColor;
import com.example.shell.enums.CardRarity;
import com.example.shell.enums.CardType;

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
