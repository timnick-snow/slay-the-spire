package com.example.shell.items.bless;

import com.example.shell.enums.CardColor;
import com.example.shell.items.card.Card;
import com.example.shell.temp.RunContext;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RandomCurse extends RandomCard {
    @Override
    public String trait() {
        return "诅咒";
    }

    @Override
    public Predicate<Card> filter(RunContext ctx) {
        return card -> card.color() == CardColor.CURSE;
    }
}
