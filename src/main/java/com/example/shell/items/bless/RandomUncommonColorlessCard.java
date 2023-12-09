package com.example.shell.items.bless;

import com.example.shell.enums.CardColor;
import com.example.shell.enums.CardRarity;
import com.example.shell.items.card.Card;
import com.example.shell.temp.RunContext;

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
