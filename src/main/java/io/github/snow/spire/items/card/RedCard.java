package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardColor;

/**
 * 战士的卡
 *
 * @author snow
 * @since 2023/12/7
 */
public abstract class RedCard implements PlayCard {
    @Override
    public CardColor color() {
        return CardColor.RED;
    }
}
