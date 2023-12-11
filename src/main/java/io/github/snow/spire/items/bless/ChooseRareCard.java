package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.temp.RunContext;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/8
 */
public class ChooseRareCard extends ChooseCard {

    @Override
    public String trait() {
        return "稀有";
    }

    @Override
    public Predicate<Card> filter(RunContext ctx) {
        return card -> card.rarity() == CardRarity.RARE && card.color() == ctx.getCharacter().color();
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.BETTER_REWARD;
    }
}
