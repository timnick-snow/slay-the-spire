package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardColor;

/**
 * @author snow
 * @since 2023/12/12
 */
public abstract class ColorlessCard extends BaseCard {

    public ColorlessCard(String id, int level) {
        super(id, level);
    }

    @Override
    public CardColor color() {
        return CardColor.COLOURLESS;
    }
}
