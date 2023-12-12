package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.Characters;

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

    int cost();

    Card copy(String id);

    default boolean isRemovable() {
        return true;
    }

    default String costDisplay() {
        int cost = cost();
        if (cost == -1) {
            return "X";
        }
        if (cost == -2) {
            return "N";
        }
        return String.valueOf(cost);
    }

    /**
     * 特属于某职业
     */
    default Characters classSpecific() {
        return switch (color()) {
            case RED -> Characters.IRONCLAD;
            case GREEN -> Characters.SILENT;
            case BLUE -> Characters.DEFECT;
            case PURPLE -> Characters.WATCHER;
            case COLOURLESS, CURSE -> null;
        };
    }
}
