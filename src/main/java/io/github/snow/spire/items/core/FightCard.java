package io.github.snow.spire.items.core;

import io.github.snow.spire.items.card.Card;

/**
 * @author snow
 * @since 2023/12/15
 */
public record FightCard(Card card, DisplayAble host) implements DisplayAble {
    @Override
    public String displayName() {
        return card.displayName();
    }
}
