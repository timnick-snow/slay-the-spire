package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.temp.RunContext;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RandomUncommonColorlessCard extends RandomCard {

    @Override
    public String trait() {
        return "罕见的无色";
    }

    @Override
    public Predicate<Card> filter(RunContext ctx) {
        return card -> card.color() == CardColor.COLOURLESS && card.rarity() == CardRarity.UNCOMMON;
    }
}
