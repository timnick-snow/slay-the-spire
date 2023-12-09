package com.example.shell.items.bless;

import com.example.shell.enums.CardRarity;
import com.example.shell.items.card.Card;
import com.example.shell.temp.RunContext;

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
}
