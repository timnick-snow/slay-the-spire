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
public class ChooseRareColorlessCard extends ChooseCard {
    @Override
    public String trait() {
        return "稀有无色";
    }

    @Override
    public Predicate<Card> filter(RunContext ctx) {
        return card -> card.rarity() == CardRarity.RARE && card.color() == CardColor.COLOURLESS;
    }
}
