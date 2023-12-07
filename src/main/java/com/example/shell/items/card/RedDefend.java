package com.example.shell.items.card;

import com.example.shell.enums.CardRarity;
import com.example.shell.enums.CardType;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
public class RedDefend extends RedCard {
    private final String id;

    @Override
    public CardType type() {
        return CardType.SKILL;
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
        return "防御";
    }

    @Override
    public String description() {
        return "获得5点格挡。";
    }

    @Override
    public int energy() {
        return 1;
    }
}
