package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.temp.RunContext;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RandomRareCard extends RandomCard {
    @Override
    public String trait() {
        return "稀有";
    }

    @Override
    public Predicate<Card> filter(RunContext ctx) {
        return card -> card.color() == ctx.getCharacter().color() && card.rarity() == CardRarity.RARE;
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.CARD_RELATED;
    }
}
