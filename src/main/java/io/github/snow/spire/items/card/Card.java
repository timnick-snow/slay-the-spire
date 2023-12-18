package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.*;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.EffectProducer;

public interface Card extends DisplayAble, EffectProducer {

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
    String baseName();

    /**
     * 显示名称
     */
    @Override
    default String displayName() {
        return baseName();
    }

    /**
     * 介绍
     */
    String description();

    int cost();

    Card copy(String id);

    boolean isPlayable();

    default CardPosition positionOnEnd() {
        return CardPosition.DISCARD_PILE;
    }

    default boolean isRemovable() {
        return true;
    }

    default String costDisplay() {
        return costDisplay(cost());
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

    static String costDisplay(int cost) {
        if (cost == -1) {
            return "X";
        }
        if (cost == -2) {
            return "N";
        }
        return String.valueOf(cost);
    }
}
