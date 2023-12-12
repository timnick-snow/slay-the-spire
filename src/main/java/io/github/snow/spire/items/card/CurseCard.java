package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public abstract class CurseCard implements Card {
    protected final String id;

    public CurseCard(String id) {
        this.id = id;
    }

    @Override
    public CardColor color() {
        return CardColor.CURSE;
    }

    @Override
    public CardType type() {
        return CardType.CURSE;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.CURSE;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public int cost() {
        return -2;
    }
}
