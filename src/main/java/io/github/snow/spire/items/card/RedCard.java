package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardColor;

/**
 * 战士的卡
 *
 * @author snow
 * @since 2023/12/7
 */
public abstract class RedCard extends BaseCard {
    public RedCard(String id, int level) {
        super(id, level);
    }

    @Override
    public CardColor color() {
        return CardColor.RED;
    }
}
