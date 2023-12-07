package com.example.shell.items.card;

import com.example.shell.enums.CardColor;
import com.example.shell.enums.CardRarity;
import com.example.shell.enums.CardType;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
public class Bash extends RedCard {
    private final String id;

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return "痛击";
    }

    @Override
    public String description() {
        return "造成8点伤害，并对敌人施加2层易伤。";
    }

    @Override
    public int energy() {
        return 2;
    }
}
