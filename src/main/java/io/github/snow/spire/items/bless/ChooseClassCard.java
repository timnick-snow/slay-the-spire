package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.temp.RunContext;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/8
 */
public class ChooseClassCard extends ChooseCard {

    @Override
    public String trait() {
        return "";
    }

    @Override
    public Predicate<Card> filter(RunContext ctx) {
        return card -> card.color() == ctx.getCharacter().color();
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.CARD_RELATED;
    }
}
